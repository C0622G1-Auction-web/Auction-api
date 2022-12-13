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

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: find product by id
     * @param productId
     * @return Optional<Product>
     */

    @Query(value = "select p.*, ps.step as price_step, concat(u.first_name,\" \",u.last_name) as full_name, u.point_dedication, ut.name as user_type\n" +
            "from product p\n" +
            "join `user` u on p.user_id = u.id\n" +
            "join user_type ut on u.user_type_id = ut.id\n" +
            "join price_step ps on p.price_step_id = ps.id\n" +
            "where p.id=:productId and p.delete_status = 0 and p.auction_status_id = 2", nativeQuery = true)
    Optional<Product> findProductById(@Param("productId") Integer productId);
}
