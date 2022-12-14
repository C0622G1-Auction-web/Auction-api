package com.project.controller.product;

import com.project.dto.product.ProductDto;
import com.project.model.product.Product;
import com.project.service.product.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin("*")
public class ProductRestController {
    @Autowired
    private IProductService productService;

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
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductDto productDto, BindingResult bindingResult) {

        new ProductDto().validate(productDto, bindingResult);

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productService.saveProduct(product);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
