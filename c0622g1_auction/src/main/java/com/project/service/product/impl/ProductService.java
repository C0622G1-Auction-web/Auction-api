package com.project.service.product.impl;


import com.project.dto.product.ProductSearchByRoleAdminDto;
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

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to find products list by List ids
     *
     * @param idList
     * @return product list
     */
    @Override
    public List<Product> findByListId(List<Integer> idList) {
        return productRepository.findByListId(idList);
    }

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to delete products list by List ids
     *
     * @param idList
     */
    @Override
    public void removeByListId(List<Integer> idList) {
        productRepository.removeByListId(idList);
    }

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to get products in page
     *
     * @param pageable
     * @return product page
     */
    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.getAll(pageable);
    }

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to search products by product name and category and seller name
     * and product initial price and auction status
     *
     * @param productSearchByRoleAdminDto
     * @param pageable
     * @return product page
     */
    @Override
    public Page<Product> searchByRoleAdmin(ProductSearchByRoleAdminDto productSearchByRoleAdminDto, Pageable pageable) {
        return productRepository.searchByRoleAdmin(productSearchByRoleAdminDto, pageable);
    }

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to find product by id
     *
     * @param id
     * @return Optional product
     */
    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to review product
     *
     * @param id
     */
    @Override
    public void review(Integer id) {
        productRepository.reviewProduct(id);
    }

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to don't review product
     *
     * @param id
     */
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
