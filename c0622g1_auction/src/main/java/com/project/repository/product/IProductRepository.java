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

    @Query(value = "select * from product where delete_status = 0 and product.id = :id",nativeQuery = true)
    Optional<Product> findProductById(@Param("id") Integer id);
}
