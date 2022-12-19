package com.project.controller.product;


import com.project.dto.product.ImgUrlProductDto;
import com.project.model.product.ImgUrlProduct;
import com.project.model.product.Product;
import com.project.service.product.IImgUrlProductService;
import com.project.service.product.impl.ImgUrlProductService;
import com.project.service.product.impl.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auction/api/v1/products/img")
@CrossOrigin("*")
public class ImageProductRestController {
    @Autowired
    private ImgUrlProductService imgUrlProductService;

    @Autowired
    private ProductService productService;

    /**
     * Create by: SonPT,
     * Date created: 13/12/2022
     * Function: find all image url by id of product
     * @pathVariable: id of product
     * @return list of image url and status code
     */

    @GetMapping("/{id}")
    public ResponseEntity<List<ImgUrlProduct>> findImgProductById(@PathVariable int id) {
        List<ImgUrlProduct> listImg = imgUrlProductService.findImgByProductId(id);
        if (listImg.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listImg, HttpStatus.OK);
    }

    /**
     * Create by: SonPT,
     * Date created: 13/12/2022
     * Function: save a new image url for a product
     * @Param: a item of ImgUrlGuide
     * @return status code
     */

    @PostMapping("/create")
    public ResponseEntity<List<FieldError>> saveImgProduct(@Validated @RequestBody ImgUrlProductDto imgUrlProductDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        ImgUrlProduct imgUrlProduct = new ImgUrlProduct();
        BeanUtils.copyProperties(imgUrlProductDTO, imgUrlProduct);
        Product product = productService.getProduct(imgUrlProductDTO.getProduct());
        imgUrlProduct.setProduct(product);
        imgUrlProductService.saveImgProduct(imgUrlProduct);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
