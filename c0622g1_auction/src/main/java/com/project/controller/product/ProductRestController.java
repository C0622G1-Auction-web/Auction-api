package com.project.controller.product;



import com.project.model.product.*;
import com.project.model.product.dto.ImgUrlProductDTO;
import com.project.model.product.dto.ProductDTO;
import com.project.service.product.ICategoryService;
import com.project.service.product.IImgUrlProductService;
import com.project.service.product.IPriceStepService;
import com.project.service.product.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


import com.project.dto.ProductSearchByRoleAdminDto;
import com.project.dto.product.ProductDto;
import com.project.dto.product.ProductSearchDto;
import com.project.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    @PostMapping("create")
    public ResponseEntity<List<FieldError>> create(@RequestBody @Validated ProductDTO productDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        productService.saveProduct(productDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * Function: update product
     *
     * @param productDTO,bindingResult
     * @return HttpStatus.create or (bindingResult.getFieldErrors() and HttpStatus.NOT_ACCEPTABLE)
     */
    @PutMapping("update")
    public ResponseEntity<List<FieldError>> update(@RequestBody @Validated ProductDTO productDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        productService.update(productDTO);
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

    @RequestMapping("img/create")
    public ResponseEntity<List<FieldError>> saveImgProduct(@Validated @RequestBody ImgUrlProductDTO imgUrlProductDTO,BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        iImgUrlProductService.saveImgProduct(imgUrlProductDTO);
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
     * @param productSearchDto
     * @param pageable
     * @return HttpStatus.NOT_FOUND if result is empty
     * @return HttpStatus.OK if result is not empty
     */
    @GetMapping("/search")
    public ResponseEntity<Page<ProductDto>> getAllAndSearch(@RequestBody ProductSearchDto productSearchDto,
                                                            @PageableDefault(value = 5) Pageable pageable) {

        Page<Product> productPage = productService.getAllAndSearch(productSearchDto, pageable);
        if(productPage.hasContent()) {
            Page<ProductDto> productDtoPage  = productPage.map(new Function<Product, ProductDto>() {
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
