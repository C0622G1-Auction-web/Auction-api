package com.project.service.product.impl;

import com.project.dto.product.ProductSearchDto;
import com.project.model.product.Product;
import com.project.repository.product.IProductRepository;
import com.project.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    /**
     * Created SangDD
     * Date created 13/12/2022
     * Function: search and filter product by name, rangePrice, categoryID productAuctionStatus
     * @param productSearchDto
     * @param pageable
     * @return Page<Product>
     */
    @Override
    public Page<Product> getAllAndSearch(ProductSearchDto productSearchDto, Pageable pageable) {
        return productRepository.getAllAndSearch(productSearchDto, pageable);
    }
}
