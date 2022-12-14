package com.project.repository.product;


import com.project.model.product.ImgUrlProduct;
import com.project.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.project.dto.ProductDto;
import com.project.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import java.util.Optional;


@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {

    /**

     * Created by: SonPT
     * Date created: 13-12-2022
     * @param: description, end_time, initial_price, name, register_day, start_time, category_id, price_step_id, user_id
     * Function: create Product
     */
    @Modifying
    @Query(value = "INSERT INTO product " +
            "(`description`, `end_time`, `initial_price`, `name`, `start_time`, `category_id`, `price_step_id`, `user_id`) VALUES " +
            "( :description, :end_time, :initial_price, :name, :start_time, :category_id, :price_step_id, :user_id);",
            nativeQuery = true)
    void createProduct(@Param("description") String description, @Param("end_time") String endTime,
                          @Param("initial_price") Double initialPrice, @Param("name") String name,
                          @Param("start_time") String startTime, @Param("category_id") Integer categoryId,
                          @Param("price_step_id") Integer priceStepId, @Param("user_id") Integer user_id);
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: find product by id
     * @param productId
     * @return HttpStatus.NOT_FOUND if result is not present or HttpStatus.OK if result is present
     */

    @Query(value = "select p.*"+
            "from product p\n" +
            "where p.id=:productId and p.delete_status = 0 and p.auction_status_id = 2", nativeQuery = true)
    Optional<Product> findProductById(@Param("productId") Integer productId);

}
