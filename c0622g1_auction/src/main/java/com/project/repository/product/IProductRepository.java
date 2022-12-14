package com.project.repository.product;

import com.project.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select * from product where delete_status = 0 and product.id = :id", nativeQuery = true)
    Optional<Product> findProductById(@Param("id") Integer id);


    @Query(value = "insert into product(name,initial_price,user_id,category_id, description, price_step_id,start_time, end_time, register_day, auction_status_id review_status_id) " +
            "values (?1,?2,?3,?4,?5,?6,?7,?8,?9,1,1)", nativeQuery = true)
    void saveProduct(String name, Double initialPrice, Integer id, Integer category, String description, Integer stepPrice, String startTime, String endTime, String registerDay);
    @Query(value = "update product set name = ?1,initial_price =?2,user_id=?3,category_id=?4, description=?5, price_step_id=?6,start_time=?7, end_time=?8, register_day=?9 where id=?10 ",nativeQuery = true)
    void updateProduct(String name, Double initialPrice, Integer id, Integer id1, String description, Integer id2, String startTime, String endTime, String registerDay, int id3);
}
