package com.project.controller.product;

import com.project.model.product.Product;
import com.project.service.product.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/products")
public class ProductRestController {
    @Autowired
    private IProductService productService;

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: create product to auction
     * @param: description, endTime, initialPrice, name, registerDay, startTime, categoryId, priceStepId, user_id
     * @return: HttpStatus.BAD_REQUEST
     * @return: HttpStatus.NO_CONTENT if create product lose, ex: has a validate,....
     * @return: HttpStatus.OK if create product success, ex: no validate, ....
     */

    @PostMapping
    public ResponseEntity<Product> addQuanLyVe(@RequestBody Product product) {

        Product products = new Product();
        BeanUtils.copyProperties(product, products);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
