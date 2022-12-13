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

    @Query(value = "select * from product where id=:productId and delete_status = 0 and auction_status_id = 2", nativeQuery = true)
    Optional<Product> findProductById(@Param("productId") Integer productId);
}
