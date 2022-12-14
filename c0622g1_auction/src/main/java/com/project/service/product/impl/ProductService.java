package com.project.service.product.impl;


import com.project.dto.ProductDto;
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


    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: save Product
     */

    @Override
    public void saveProduct(Product product) {
        productRepository.createProduct(product.getDescription(), product.getEndTime(), product.getInitialPrice(), product.getName(), product.getStartTime(), product.getCategory().getId(), product.getPriceStep().getId(), product.getUser().getId());

    }

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: find product by id
     *
     * @param productId
     * @return HttpStatus.NOT_FOUND if result is not present or HttpStatus.OK if result is present
     */

    @Override
    public Optional<Product> findProductById(Integer productId) {
        return productRepository.findProductById(productId);

    }
}
