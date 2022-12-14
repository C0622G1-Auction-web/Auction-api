package com.project.service.product;

import com.project.model.product.Product;
import com.project.model.product.dto.ProductDTO;

import java.util.Optional;

public interface IProductService {
    Optional<Product> findById(Integer id);

    void saveProduct(Product product);

    void update(Product product);
}
