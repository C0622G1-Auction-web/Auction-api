package com.project.repository.product;

import com.project.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {
    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: get create product status
     * @return product status success
     */
    @Modifying
    @Query(value = "INSERT INTO `project1`.`product` " +
            "(`delete_status`, `description`, `end_time`, `initial_price`, `name`, `register_day`, `start_time`, `auction_status_id`, `category_id`, `price_step_id`, `review_status_id`, `user_id`) VALUES " +
            "('1', :description, :end_time, :initial_price, :name, :register_day, :start_time, '1', :category_id, :price_step_id, '1', :user_id);",
            nativeQuery = true)
    Product createProduct(@Param("description") String description, @Param("end_time") String endTime,
                          @Param("initial_price") Double initialPrice, @Param("name") String name,
                          @Param("register_day") String registerDay, @Param("start_time") String startTime, @Param("category_id") Integer categoryId,
                          @Param("price_step_id") Integer priceStepId, @Param("user_id") Integer user_id);
}
