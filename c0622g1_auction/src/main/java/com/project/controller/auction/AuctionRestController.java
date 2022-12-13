package com.project.controller.auction;

import com.project.model.product.Product;
import com.project.service.auction.IAuctionService;
import com.project.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/auction/api")
public class AuctionRestController {
    @Autowired
    private IAuctionService auctionService;

    @Autowired
    private IProductService productService;

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: find product by id
     *
     * @param productId
     * @return HttpStatus.NOT_FOUND if productOptional.isPresent() = false
     */
    @GetMapping("/{productId}")
    public ResponseEntity<Product> findProductById(@PathVariable(value = "productId") Integer productId) {
        Optional<Product> productOptional = productService.findProductById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
