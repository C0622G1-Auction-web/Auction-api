package com.project.service.product.impl;

import com.project.model.product.Product;
import com.project.repository.product.IProductRepository;
import com.project.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: save Product
     */

    @Override
    public void saveProduct(Product product) {
         productRepository.createProduct(product.getDescription(), product.getEndTime(), product.getInitialPrice(), product.getName(), product.getStartTime(), product.getCategory().getId(), product.getPriceStep().getId(), product.getUser().getId());
    }
}
