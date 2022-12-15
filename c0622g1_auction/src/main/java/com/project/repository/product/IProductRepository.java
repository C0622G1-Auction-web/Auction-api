package com.project.repository.product;

import com.project.dto.ProductDto;
import com.project.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {

    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function: get page products Sign up for auctions by user id
     * @param user id
     * @param pageable
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */

    @Query(value = "select product.`name` as nameProduct, product.description as description, " +
            "product.register_day as registerDay , review_status.`name` as review , product.delete_status as isDelete " +
            "from product " +
            "join user on product.user_id = user.id " +
            "join review_status on review_status.id = product.review_status_id " +
            "where product.user_id = :id ",
            countQuery = "count (*)from product " +
                    "join user on product.user_id = user.id " +
                    "join review_status on review_status.id = product.review_status_id " +
                    "where product.user_id = :id  ", nativeQuery = true)
    Page<ProductDto> showProductById(@Param("id") Integer id, Pageable pageable);


    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function: cancel Sign up for auctions by user id
     * @param user id
     * @return voice
     */
    @Modifying
    @Transactional
    @Query(value = " UPDATE  product set delete_status = 1 where product.id = :id ", nativeQuery = true)
    void cancelProduct(@Param("id") Integer id);
}
