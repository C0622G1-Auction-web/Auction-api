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
     * Function: get all product status
     * @return product status list
     */

    @Override
    public Product saveProduct(String description, String endTime, Double initialPrice, String name, String registerDay, String startTime, Integer categoryId, Integer priceStepId, Integer user_id) {
        return productRepository.createProduct(description, endTime, initialPrice, name, registerDay, startTime, categoryId, priceStepId, user_id);
    }
}
