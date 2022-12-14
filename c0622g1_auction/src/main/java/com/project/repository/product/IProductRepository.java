package com.project.repository.product;

import com.project.dto.ProductDto;
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

    /**
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
