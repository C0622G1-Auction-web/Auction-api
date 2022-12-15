package com.project.service.product.impl;


<<<<<<< HEAD
import com.project.dto.product.ProductSearchByRoleAdminDto;
=======
import com.project.model.product.Product;
import com.project.model.product.dto.ProductDTO;

import com.project.dto.ProductSearchByRoleAdminDto;
>>>>>>> 36e019559080780e3aa592ba0c210420f2b24902
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
    public void saveProduct(ProductDTO productDTO) {
        productRepository.saveProduct(productDTO.getName(), productDTO.getInitialPrice(), productDTO.getUser(),
                productDTO.getCategory(), productDTO.getDescription(), productDTO.getPriceStep(),
                productDTO.getStartTime(), productDTO.getEndTime(), productDTO.getRegisterDay(),productDTO.getAuctionStatus(),productDTO.getReviewStatus());
    }

    @Override
    public void update(ProductDTO productDTO) {
        productRepository.updateProduct(productDTO.getName(), productDTO.getInitialPrice(), productDTO.getUser(),
                productDTO.getCategory(), productDTO.getDescription(), productDTO.getPriceStep(),
                productDTO.getStartTime(), productDTO.getEndTime(), productDTO.getRegisterDay(), productDTO.getId());

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
     *
     * @param productSearchDto
     * @param pageable
     * @return Page<Product>
     */


    @Override
    public Page<Product> getAllAndSearch(ProductSearchDto productSearchDto, Pageable pageable) {
        return productRepository.getAllAndSearch(productSearchDto, pageable);

    }

}
