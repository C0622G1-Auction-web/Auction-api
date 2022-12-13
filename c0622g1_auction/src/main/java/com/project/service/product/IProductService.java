package com.project.service.product;

import com.project.controller.dto.ProductSearchDto;
import com.project.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> getAllAndSearch(ProductSearchDto productSearchDto, Pageable pageable);
}
