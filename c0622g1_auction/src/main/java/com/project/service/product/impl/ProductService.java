package com.project.service.product.impl;

import com.project.model.product.Product;
import com.project.model.product.dto.ProductDTO;
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
    public Optional<Product> findById(Integer id) {
        return productRepository.findProductById(id);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.saveProduct(product.getName(), product.getInitialPrice(),product.getUser().getId(),
                product.getCategory().getId(),product.getDescription(),product.getPriceStep().getId(),
                product.getStartTime(),product.getEndTime(),product.getRegisterDay());
    }

    @Override
    public void update(Product product) {
        productRepository.updateProduct(product.getName(), product.getInitialPrice(),product.getUser().getId(),
                product.getCategory().getId(),product.getDescription(),product.getPriceStep().getId(),
                product.getStartTime(),product.getEndTime(),product.getRegisterDay(),product.getId());
    }
}
