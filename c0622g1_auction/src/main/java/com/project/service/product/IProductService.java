package com.project.service.product;

import com.project.dto.ProductDto;
import com.project.model.product.Product;

import java.util.Optional;


public interface IProductService {

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: find product by id
     * @param productId
     * @return HttpStatus.OK if result is present
     * @return HttpStatus.NOT_FOUND if result is not present
     */

    Optional<Product> findProductById(Integer productId);
}
