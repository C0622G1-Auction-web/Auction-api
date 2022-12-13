package com.project.repository.product;

import com.project.model.product.Product;
import com.project.model.product.ReviewStatus;
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
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to get products in page
     * @param pageable
     * @return product page
     */
    @Query(value = "select * from product where delete_status = 0 ", nativeQuery = true)
    Page<Product> getAll(Pageable pageable);

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to delete product by List ids
     * @param idList
     */
    @Transactional
    @Modifying
    @Query(value = "update product set delete_status = 1 where id in [idList]", nativeQuery = true)
    void remove(@Param("idList") List<Integer> idList);

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to review product
     * @param id
     */
    @Transactional
    @Modifying
    @Query(value = "update product set review_status_id = 2 where id = :id", nativeQuery = true)
    void reviewProduct(@Param(":id") Integer id);

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to don't review product
     * @param id
     */
    @Transactional
    @Modifying
    @Query(value = "update product set review_status_id = 3 where id = :id", nativeQuery = true)
    void doNotReviewProduct(@Param(":id") Integer id);

}
