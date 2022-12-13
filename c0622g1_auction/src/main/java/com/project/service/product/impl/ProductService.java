package com.project.service.product.impl;

import com.project.model.product.Product;
import com.project.repository.product.IProductRepository;
import com.project.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Optional<Product> findProductById(Integer productId) {
        return productRepository.findProductById(productId);
    }
}
