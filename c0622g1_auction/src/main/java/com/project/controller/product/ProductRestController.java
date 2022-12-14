package com.project.controller.product;


import com.project.model.product.*;
import com.project.model.product.dto.ImgUrlProductDTO;
import com.project.model.product.dto.ProductDTO;
import com.project.model.users.User;
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

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
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
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);

        User user = new User();
        user.setId(productDTO.getUser().getId());
        product.setUser(user);

        ReviewStatus reviewStatus = new ReviewStatus();
        reviewStatus.setId(productDTO.getReviewStatus().getId());
        product.setReviewStatus(reviewStatus);

        AuctionStatus auctionStatus = new AuctionStatus();
        auctionStatus.setId(productDTO.getAuctionStatus().getId());;
        product.setAuctionStatus(auctionStatus);

        PriceStep priceStep = new PriceStep();
        priceStep.setId(productDTO.getPriceStep().getId());
        product.setPriceStep(priceStep);

        Category category = new Category();
        category.setId(productDTO.getCategory().getId());
        product.setCategory(category);

        Date date = new Date();
        product.setRegisterDay(String.valueOf(date));
        productService.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("update")
    public ResponseEntity<List<FieldError>> update(@RequestBody @Validated ProductDTO productDTO, BindingResult bindingResult) {
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
     * @param imgUrlProduct
     * @return HttpStatus.CREATED
     */

    @RequestMapping("img/create/img")
    public ResponseEntity<ImgUrlProduct> saveImgProduct(@RequestBody ImgUrlProduct imgUrlProduct) {
        iImgUrlProductService.saveImgProduct(imgUrlProduct);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    public ResponseEntity<ImgUrlProduct> saveImgProduct(@RequestBody ImgUrlProductDTO imgUrlProductDTO) {
//        iImgUrlProductService.saveImg(imgUrlProductDTO);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
}
