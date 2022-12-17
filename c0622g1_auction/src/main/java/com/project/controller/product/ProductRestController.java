package com.project.controller.product;

import com.project.dto.product.*;
import com.project.dto.user.UserDto;
import com.project.model.product.*;
import com.project.model.users.User;
import com.project.service.product.ICategoryService;
import com.project.service.product.IPriceStepService;
import com.project.service.product.IProductService;
import com.project.service.product.impl.AuctionStatusService;
import com.project.service.product.impl.ReviewStatusService;
import com.project.service.users.impl.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.project.dto.ProductSearchByRoleAdminDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.Date;
import java.util.function.Function;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin("*")
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


    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: create product to auction
     *
     * @param: description, endTime, initialPrice, name, registerDay, startTime, categoryId, priceStepId, user_id
     * @return: HttpStatus.BAD_REQUEST
     * @return: HttpStatus.NO_CONTENT if create product lose, ex: has a validate,....
     * @return: HttpStatus.OK if create product success, ex: no validate, ....
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
        product.setDeleteStatus(false);
        productService.saveProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
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
     * @param id
     * @return HttpStatus.NO_CONTENT if not found product /  HttpStatus.OK and product if found
     */
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Integer id) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(optionalProduct.get(), HttpStatus.OK);
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
