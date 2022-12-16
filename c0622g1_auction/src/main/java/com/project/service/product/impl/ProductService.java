package com.project.service.product.impl;

import com.project.dto.IProductDto;
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
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function: get page products Sign up for auctions by user id
     * @param 'user id'
     * @param pageable
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */
    @Override
    public Page<IProductDto> showProductById(Integer id, Pageable pageable) {
        return productRepository.showProductById(id, pageable);
    }

    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function: get page products Sign up for auctions by user id
     * @param 'user id'
     * @return void
     */

    @Override
    public void cancelProduct(Integer id) {
        productRepository.cancelProduct(id);
    }

}
