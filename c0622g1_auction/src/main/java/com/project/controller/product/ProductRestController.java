package com.project.controller.product;


import com.project.dto.product.*;
import com.project.model.product.ReviewStatus;
import com.project.model.product.*;
import com.project.model.users.User;
import com.project.service.product.*;
import com.project.service.product.impl.AuctionStatusService;
import com.project.service.product.impl.ReviewStatusService;
import com.project.service.users.impl.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/products")
public class ProductRestController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IPriceStepService priceStepService;

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewStatusService reviewStatusService;

    @Autowired
    private AuctionStatusService auctionStatusService;

    @Autowired
    private IImgUrlProductService iImgUrlProductService;

    @Autowired
    private IProductPropertiesService productPropertiesService;

    /**
     * Create by: HungNV,
     * Date created: 15/12/2022
     * Function: get list of categories
     *
     * @return categoryList and HttpStatus.OK
     */
    @GetMapping("category")
    public ResponseEntity<List<Category>> getListCategory() {
        List<Category> categoryList = categoryService.getListCategory();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    /**
     * Create by: HungNV,
     * Date created: 15/12/2022
     * Function: get list of priceStep
     *
     * @return priceStepList and HttpStatus.OK
     */
    @GetMapping("priceStep")
    public ResponseEntity<List<PriceStep>> getListPriceStep() {
        List<PriceStep> priceStepList = priceStepService.getListPriceStep();
        if (priceStepList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(priceStepList, HttpStatus.OK);
    }

    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * Function: find product by product id
     *
     * @param id
     * @return product and HttpStatus.OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id) {
        Optional<Product> product = productService.findByProductId(id);
        if (!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * Function: create new product
     *
     * @param productDtoCreate,bindingResult
     * @return HttpStatus.create or (bindingResult.getFieldErrors() and HttpStatus.NOT_ACCEPTABLE)
     */
    @PostMapping("/create")
    public ResponseEntity<Product> create(@Validated @RequestBody ProductDtoCreate productDtoCreate, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Date date = new Date();
        productDtoCreate.setRegisterDay(String.valueOf(date));
        Product product = new Product();
        BeanUtils.copyProperties(productDtoCreate, product);
        PriceStep priceStep = priceStepService.getPriceStep(productDtoCreate.getPriceStep());
        product.setPriceStep(priceStep);
        Category category = categoryService.getCategory(productDtoCreate.getCategory());
        product.setCategory(category);
        ReviewStatus reviewStatus = reviewStatusService.getReviewStatus(1);
        product.setReviewStatus(reviewStatus);
        AuctionStatus auctionStatus = auctionStatusService.getAuctionStatus(1);
        product.setAuctionStatus(auctionStatus);
        User user = userService.getUser(productDtoCreate.getUser());
        product.setUser(user);
        productService.saveProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * Function: update product
     *
     * @param productDtoCreate,bindingResult
     * @return HttpStatus.create or (bindingResult.getFieldErrors() and HttpStatus.NOT_ACCEPTABLE)
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody @Validated ProductDtoCreate productDtoCreate, BindingResult bindingResult, @PathVariable Integer id) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        Product product = productService.getProduct(id);
        BeanUtils.copyProperties(productDtoCreate, product);
        PriceStep priceStep = priceStepService.getPriceStep(productDtoCreate.getPriceStep());
        product.setPriceStep(priceStep);
        Category category = categoryService.getCategory(productDtoCreate.getCategory());
        product.setCategory(category);
        ReviewStatus reviewStatus = reviewStatusService.getReviewStatus(productDtoCreate.getReviewStatus());
        product.setReviewStatus(reviewStatus);
        AuctionStatus auctionStatus = auctionStatusService.getAuctionStatus(productDtoCreate.getAuctionStatus());
        product.setAuctionStatus(auctionStatus);
        User user = userService.getUser(productDtoCreate.getUser());
        product.setUser(user);
        product.setRegisterDay(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY")));
        productService.update(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    /**
     * Create by AnhTDQ
     * Date created: 15/12/2022
     * Function: get all products Sign up for auctions
     *
     * @return HttpStatus.NO_CONTENT if not found any product /  HttpStatus.OK and Products page if found
     */
    @GetMapping("/list/{id}")
    public ResponseEntity<Page<IProductDto>> historyProduct(Integer id, Pageable pageable) {
        Page<IProductDto> productList = productService.showProductById(1, pageable);

        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    /**
     * Create by AnhTDQ
     * Date created: 15/12/2022
     * Function: cancel products Sign up for auctions
     *
     * @param id
     * @return : HttpStatus.OK and cancel successfully
     */
    @GetMapping("/canceled/{id}")
    public ResponseEntity<Product> canceledProduct(@PathVariable("id") Integer id) {
        productService.cancelProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by AnhTDQ
     * Date created: 15/12/2022
     * Function: get all reviewStatus of Sign up for auctions
     *
     * @return HttpStatus.NO_CONTENT if not found any reviewStatus /  HttpStatus.OK and  list reviewStatus if found
     */
    @GetMapping("/listReviewStatus")
    public ResponseEntity<List<ReviewStatus>> showReviewStatus() {
        List<ReviewStatus> reviewStatusList = reviewStatusService.findAll();
        if (reviewStatusList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reviewStatusList, HttpStatus.OK);
    }

    /**
     * Create by: HungNV,
     * Date created: 19/12/2022
     * Function: create new image of product
     *
     * @param imgUrlProductDto
     * @return imgUrlProduct and HttpStatus.CREATED / bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE
     */
    @PostMapping("img/create")
    public ResponseEntity<List<FieldError>> saveImgProduct(@Validated @RequestBody ImgUrlProductDto imgUrlProductDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        ImgUrlProduct imgUrlProduct = new ImgUrlProduct();
        BeanUtils.copyProperties(imgUrlProductDto, imgUrlProduct);
        Product product = productService.getProduct(imgUrlProductDto.getProduct());
        imgUrlProduct.setProduct(product);
        iImgUrlProductService.saveImgProduct(imgUrlProduct);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Create by: HungNV,
     * Date created: 13/12/2022
     * Function: find img product by product id
     *
     * @param id
     * @return listImg and HttpStatus.OK
     */
    @GetMapping("img/{id}")
    public ResponseEntity<List<ImgUrlProduct>> findImgProductId(@PathVariable Integer id) {
        List<ImgUrlProduct> listImg = iImgUrlProductService.findImgByProductId(id);
        if (listImg.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listImg, HttpStatus.OK);
    }

    /**
     * Create by: HungNV,
     * Date created: 17/12/2022
     * Function: update img product of product
     *
     * @param imgUrlProductDto
     * @return imgUrlProduct and HttpStatus.CREATED / bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE
     */
    @PutMapping("img/update/{id}")
    public ResponseEntity<?> updateImageProduct(@Validated @RequestBody ImgUrlProductDto imgUrlProductDto, BindingResult bindingResult, @PathVariable Integer id) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        ImgUrlProduct imgUrlProduct = iImgUrlProductService.getImgUrlProduct(id);
        BeanUtils.copyProperties(imgUrlProductDto, imgUrlProduct);
        Product product = productService.getProduct(imgUrlProductDto.getProduct());
        imgUrlProduct.setProduct(product);
        iImgUrlProductService.update(imgUrlProduct);
        return new ResponseEntity<>(imgUrlProduct, HttpStatus.CREATED);
    }

    /**
     * Create by: HungNV,
     * Date created: 17/12/2022
     * Function: delete image
     *
     * @param id
     * @return imgUrlProduct and HttpStatus.CREATED / bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE
     */
    @DeleteMapping("img/delete/{id}")
    public ResponseEntity<ImgUrlProduct> deleteImageById(@PathVariable Integer id) {
        ImgUrlProduct imgUrlProduct = iImgUrlProductService.getImgUrlProduct(id);
        iImgUrlProductService.delete(imgUrlProduct);
        return new ResponseEntity<>(imgUrlProduct, HttpStatus.OK);
    }

    /**
     * Create by GiangLBH
     * Date created: 13/12/2022
     * Function: get all products
     *
     * @return HttpStatus.NO_CONTENT if not found any product /  HttpStatus.OK and Products page if found
     */
    @GetMapping
    public ResponseEntity<Page<Product>> getAll(@PageableDefault(value = 5) Pageable pageable) {
        Page<Product> productPage = productService.getAll(pageable);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    /**
     * Create by GiangLBH
     * Date created: 13/12/2022
     * Function: to delete products by idList
     *
     * @param idList
     * @return HttpStatus.OK if remove successfully / HttpStatus.NOT_FOUND if exists not found product
     */
    @PostMapping("/remove")
    public ResponseEntity<HttpStatus> remove(@RequestBody List<Integer> idList) {
        if (idList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<ProductDeleteDto> productList = productService.findByListId(idList);
        if (idList.size() != productList.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.removeByListId(idList);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to review product
     *
     * @param id
     * @return HttpStatus.NO_CONTENT if not found product /  HttpStatus.OK if found
     */
    @GetMapping("/review/{id}")
    public ResponseEntity<HttpStatus> review(@PathVariable("id") Integer id) {
        Optional<ProductDtoAdminList> optionalProduct = productService.findDtoById(id);
        if (!optionalProduct.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.review(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to review product
     *
     * @param id
     * @return HttpStatus.NO_CONTENT if not found product /  HttpStatus.OK if found
     */
    @GetMapping("/do-not-review/{id}")
    public ResponseEntity<HttpStatus> doNotReview(@PathVariable("id") Integer id) {
        Optional<ProductDtoAdminList> optionalProduct = productService.findDtoById(id);
        if (!optionalProduct.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.doNotReview(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to find product by id
     *
     * @param idList
     * @return HttpStatus.NO_CONTENT if exists any product not found/  HttpStatus.OK and products found
     */
    @PostMapping("/find-by-list-id")
    public ResponseEntity<List<ProductDeleteDto>> findByListId(@RequestBody List<Integer> idList) {
        if (idList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<ProductDeleteDto> productDeleteDtos = productService.findByListId(idList);
        if (idList.size() != productDeleteDtos.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productDeleteDtos, HttpStatus.OK);
    }

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to find product by id
     *
     * @param id
     * @return HttpStatus.NO_CONTENT if null found/  HttpStatus.OK and product found
     */
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<ProductDtoAdminList> findByListId(@PathVariable Integer id) {
        Optional<ProductDtoAdminList> optionalProduct = productService.findDtoById(id);
        if (!optionalProduct.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
    }


    /**
     * Created SangDD
     * Date created 13/12/2022
     * Function: search and filter product by name, rangePrice, categoryID productAuctionStatus
     *
     * @param productSearchDto
     * @param pageable
     * @return HttpStatus.OK if result is not empty
     */
    @PostMapping("/search")
    public ResponseEntity<Page<ProductDto>> getAllAndSearch(@RequestBody ProductSearchDto productSearchDto,
                                                            @PageableDefault(value = 10) Pageable pageable) {
        Page<Product> productPage = productService.getAllAndSearch(productSearchDto, pageable);
        if (productPage.hasContent()) {
            Page<ProductDto> productDtoPage = productPage.map(new Function<Product, ProductDto>() {
                @Override
                public ProductDto apply(Product product) {
                    ProductDto productDto = new ProductDto();
                    BeanUtils.copyProperties(product, productDto);
                    return productDto;
                }
            });
            return new ResponseEntity<>(productDtoPage, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to search product by product name and category and seller name
     * and product initial price and auction status
     *
     * @param productSearchByRoleAdminDto
     * @param pageable
     * @return HttpStatus.NO_CONTENT if not found any product /  HttpStatus.OK and Products page if found
     */
    @PostMapping("/search-by-admin")
    public ResponseEntity<Page<ProductDtoAdminList>> searchByRoleAdmin(@RequestBody ProductSearchByRoleAdminDto productSearchByRoleAdminDto,
                                                                       @PageableDefault(value = 5) Pageable pageable) {
        List<SearchProductRange> searchRanges = productPropertiesService.getListSearchProductRange();
        for (SearchProductRange searchRange : searchRanges) {
            if (searchRange.getId().equals(productSearchByRoleAdminDto.getPriceRange())) {
                productSearchByRoleAdminDto.setMinPrice(searchRange.getMin());
                productSearchByRoleAdminDto.setMaxPrice(searchRange.getMax());
            }
        }
        Page<ProductDtoAdminList> productDtoPage = productService.searchByRoleAdmin(productSearchByRoleAdminDto, pageable);
        if (productDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productDtoPage, HttpStatus.OK);
    }

    /**
     * Create by: GiangLBH
     * Date created: 17/12/2022
     * Function: to write Reason when do not review
     *
     * @Return reason
     */
    @PostMapping("/reasons")
    public ResponseEntity<HttpStatus> writeReason(
            @RequestBody Reason reason) {
        productPropertiesService.addReason(reason);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Create by: GiangLBH
     * Date created: 17/12/2022
     * Function: to get Reason when do not review
     *
     * @Return reason
     */
    @GetMapping("/reason/{id}")
    public ResponseEntity<Reason> getReason(@PathVariable Integer id) {
        Optional<Reason> reason = productPropertiesService.getReason(id);
        if (!reason.isPresent()) {
            return new ResponseEntity<>(new Reason(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(reason.get(), HttpStatus.OK);
    }

    /**
     * Create by: GiangLBH
     * Date created: 17/12/2022
     * Function: to get img list by product id
     *
     * @Param productId
     * @Return img list
     */
    @GetMapping("/imgs/{id}")
    public ResponseEntity<List<ImgUrlProduct>> getImgsByProductId(@PathVariable Integer id) {
        List<ImgUrlProduct> imgs = iImgUrlProductService.getImgs(id);
        if (imgs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(imgs, HttpStatus.OK);
    }
}

