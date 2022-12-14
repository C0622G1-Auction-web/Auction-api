package com.project.service.product;


import com.project.model.product.Product;

public interface IProductService {
    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: save Product
     */
    void saveProduct(Product product);

import com.project.dto.ProductDto;
import com.project.model.product.Product;

import java.util.Optional;


public interface IProductService {

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: find product by id
     * @param productId
     * @return HttpStatus.NOT_FOUND if result is not present or HttpStatus.OK if result is present
     */

    Optional<Product> findProductById(Integer productId);

}
