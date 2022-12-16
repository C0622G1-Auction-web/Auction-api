package com.project.service.product;


import com.project.model.product.Product;
import com.project.dto.ProductSearchByRoleAdminDto;

import com.project.dto.product.ProductSearchDto;

import com.project.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

import java.util.Optional;

public interface IProductService {
    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: save Product
     */
    void saveProduct(Product product);

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: find product by id
     * @param productId
     * @return HttpStatus.NOT_FOUND if result is not present or HttpStatus.OK if result is present
     */

    Optional<Product> findProductById(Integer productId);


    List<Product> findByListId(List<Integer> idList);

    void removeByListId(List<Integer> idList);

    Page<Product> getAll(Pageable pageable);

    Page<Product> searchByRoleAdmin(ProductSearchByRoleAdminDto productSearchByRoleAdminDto, Pageable pageable);

    Optional<Product> findById(Integer id);

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
