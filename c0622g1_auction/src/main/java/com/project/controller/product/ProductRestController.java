package com.project.controller.product;

import com.project.controller.dto.ProductSearchDto;
import com.project.model.product.Product;
import com.project.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/products")
public class ProductRestController {
    @Autowired
    private IProductService productService;

    @GetMapping("/search")
    public ResponseEntity<Page<Product>> getAllAndSearch(@RequestBody ProductSearchDto productSearchDto,
                                                         @PageableDefault(value = 5) Pageable pageable) {

        Page<Product> productPage = productService.getAllAndSearch(productSearchDto, pageable);
        if(productPage != null) {
            return new ResponseEntity<>(productPage, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
