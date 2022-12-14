package com.project.service.product;


import com.project.model.product.Product;
import com.project.model.product.dto.ProductDTO;

import java.util.Optional;


import com.project.dto.ProductSearchByRoleAdminDto;

import com.project.dto.product.ProductSearchDto;

import com.project.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;
public interface IProductService {


    Optional<Product> findById(Integer id);

    void saveProduct(Product product);

    void update(Product product);


    List<Product> findByListId(List<Integer> idList);

    void removeByListId(List<Integer> idList);

    Page<Product> getAll(Pageable pageable);

    Page<Product> searchByRoleAdmin(ProductSearchByRoleAdminDto productSearchByRoleAdminDto, Pageable pageable);


    void review(Integer id);

    void doNotReview(Integer id);


    /**
     * Created SangDD
     * Date created 13/12/2022
     * Function: search and filter product by name, rangePrice, categoryID productAuctionStatus
     * @param productSearchDto
     * @param pageable
     * @return Page<Product>
     */
    Page<Product> getAllAndSearch(ProductSearchDto productSearchDto, Pageable pageable);


}
