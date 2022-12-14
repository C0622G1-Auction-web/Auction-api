package com.project.service.product.impl;


import com.project.model.product.Product;
import com.project.model.product.dto.ProductDTO;

import com.project.dto.ProductSearchByRoleAdminDto;

import com.project.dto.product.ProductSearchDto;

import com.project.model.product.Product;

import com.project.repository.product.IProductRepository;
import com.project.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
        productRepository.saveProduct(product.getName(), product.getInitialPrice(), product.getUser().getId(),
                product.getCategory().getId(), product.getDescription(), product.getPriceStep().getId(),
                product.getStartTime(), product.getEndTime(), product.getRegisterDay());
    }

    @Override
    public void update(Product product) {
        productRepository.updateProduct(product.getName(), product.getInitialPrice(), product.getUser().getId(),
                product.getCategory().getId(), product.getDescription(), product.getPriceStep().getId(),
                product.getStartTime(), product.getEndTime(), product.getRegisterDay(), product.getId());

    }

    @Override
    public List<Product> findByListId(List<Integer> idList) {
        return productRepository.findByListId(idList);
    }

    @Override
    public void removeByListId(List<Integer> idList) {
        productRepository.removeByListId(idList);
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.getAll(pageable);
    }

    @Override
    public Page<Product> searchByRoleAdmin(ProductSearchByRoleAdminDto productSearchByRoleAdminDto, Pageable
            pageable) {
        return productRepository.searchByRoleAdmin(productSearchByRoleAdminDto, pageable);
    }


    @Override
    public void review(Integer id) {
        productRepository.reviewProduct(id);
    }

    @Override
    public void doNotReview(Integer id) {
        productRepository.doNotReviewProduct(id);
    }
        /**
         * Created SangDD
         * Date created 13/12/2022
         * Function: search and filter product by name, rangePrice, categoryID productAuctionStatus
         * @param productSearchDto
         * @param pageable
         * @return Page<Product>
         */

        @Override
        public Page<Product> getAllAndSearch (ProductSearchDto productSearchDto, Pageable pageable){
            return productRepository.getAllAndSearch(productSearchDto, pageable);

        }

}
