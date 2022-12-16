package com.project.controller.product;


<<<<<<< HEAD
import com.project.dto.product.ProductDtoCreate;
=======

import com.project.dto.product.ProductSearchByRoleAdminDto;


>>>>>>> 801e665c1da45a3e3fe45a72182de87023e5ee32
import com.project.model.product.*;
import com.project.dto.product.ImgUrlProductDTO;
import com.project.model.users.User;
import com.project.service.product.*;
import com.project.service.users.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.Optional;



import com.project.dto.product.ProductDto;
import com.project.dto.product.ProductSearchDto;
import com.project.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import sun.security.pkcs11.wrapper.Constants;

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
    private IImgUrlProductService iImgUrlProductService;

    @Autowired
    private IReviewStatusService reviewStatusService;

    @Autowired
    private IAuctionStatusService auctionStatusService;

    @Autowired
    private IUserService userService;
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
        Optional<Product> product = productService.findById(id);
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
     * @param productDTO,bindingResult
     * @return HttpStatus.create or (bindingResult.getFieldErrors() and HttpStatus.NOT_ACCEPTABLE)
     */

    @PostMapping("/create")
    public ResponseEntity<Product> create(@RequestBody @Validated ProductDtoCreate productDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Date date = new Date();
        productDTO.setRegisterDay(String.valueOf(date));
        Product product = new Product();

        BeanUtils.copyProperties(productDTO, product);
        PriceStep priceStep = priceStepService.getPriceStep(productDTO.getPriceStep());
        product.setPriceStep(priceStep);
        Category category = categoryService.getCategory(productDTO.getCategory());
        product.setCategory(category);
        ReviewStatus reviewStatus = reviewStatusService.getReviewStatus(1);
        product.setReviewStatus(reviewStatus);
        AuctionStatus auctionStatus = auctionStatusService.getAuctionStatus(1);
        product.setAuctionStatus(auctionStatus);
        User user = userService.getUser(productDTO.getUser());
        product.setUser(user);
        product.isDeleteStatus();
        productService.saveProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * Function: update product
     *
     * @param productDTO,bindingResult
     * @return HttpStatus.create or (bindingResult.getFieldErrors() and HttpStatus.NOT_ACCEPTABLE)
     */
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Validated ProductDto productDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        productService.update(product);
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
     * Date created: 13/12/2022
     * Function: create new img product of product
     *
     * @param imgUrlProductDTO
     * @return HttpStatus.CREATED
     */

    @PostMapping(value = {"img/create"},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
            , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<FieldError>> saveImgProduct(@Validated @RequestBody ImgUrlProductDTO imgUrlProductDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        ImgUrlProduct imgUrlProduct = new ImgUrlProduct();
        BeanUtils.copyProperties(imgUrlProductDTO, imgUrlProduct);
        Product product = productService.getProduct(imgUrlProductDTO.getProduct());
        imgUrlProduct.setProduct(product);
        iImgUrlProductService.saveImgProduct(imgUrlProduct);
        return new ResponseEntity<>(HttpStatus.CREATED);
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
        return new ResponseEntity<Page<Product>>(productPage, HttpStatus.OK);
    }

    /**
     * Create by GiangLBH
     * Date created: 13/12/2022
     * Function: to delete products by idList
     *
     * @param idList
     * @return HttpStatus.OK if remove successfully / HttpStatus.NOT_FOUND if exists not found product
     */
    @PutMapping("/remove")
    public ResponseEntity<List<Product>> remove(@RequestBody List<Integer> idList) {
        if (idList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Product> productList = productService.findByListId(idList);
        if (idList.size() != productList.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.removeByListId(idList);
        return new ResponseEntity<List<Product>>(HttpStatus.OK);
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
    @GetMapping("/searchByAdmin")
    public ResponseEntity<Page<Product>> searchByRoleAdmin(@RequestBody ProductSearchByRoleAdminDto productSearchByRoleAdminDto,
                                                           @PageableDefault(value = 5) Pageable pageable) {
        Page<Product> productPage = productService.searchByRoleAdmin(productSearchByRoleAdminDto, pageable);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<Product>>(productPage, HttpStatus.OK);
    }

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to review product
     *
     * @param id
     * @return HttpStatus.NO_CONTENT if not found product /  HttpStatus.OK if found
     */
    @PutMapping("/review/{id}")
    public ResponseEntity<Product> review(@PathVariable("id") Integer id) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.review(id);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to review product
     *
     * @param id
     * @return HttpStatus.NO_CONTENT if not found product /  HttpStatus.OK if found
     */
    @PutMapping("/do-not-review/{id}")
    public ResponseEntity<Product> doNotReview(@PathVariable("id") Integer id) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.doNotReview(id);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }


    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to find product by id
     *
     * @param idList
     * @return HttpStatus.NO_CONTENT if exists any product not found/  HttpStatus.OK and products found
     */
    @GetMapping("/find-by-list-id")
    public ResponseEntity<List<Product>> findByListId(@RequestBody List<Integer> idList) {
        if (idList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Product> productList = productService.findByListId(idList);
        if (idList.size() != productList.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
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
    @GetMapping("/search")
    public ResponseEntity<Page<ProductDto>> getAllAndSearch(@RequestBody ProductSearchDto productSearchDto,
                                                            @PageableDefault(value = 5) Pageable pageable) {

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
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
