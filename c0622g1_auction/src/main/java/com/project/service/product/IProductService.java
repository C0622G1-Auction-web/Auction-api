package com.project.service.product;

import com.project.model.product.Product;

import java.util.Optional;

public interface IProductService {
    Optional<Product> findById(Integer id);
}
