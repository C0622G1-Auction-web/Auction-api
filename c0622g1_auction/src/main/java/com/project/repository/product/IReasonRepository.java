package com.project.repository.product;

import com.project.model.product.Reason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface IReasonRepository extends JpaRepository<Reason, Integer> {

    /**
     * Create by: GiangLBH
     * Date created: 17/12/2022
     * Function: to get Reason when do not review
     *
     * @Return reason
     */
    @Query(value = "SELECT * FROM reason where product_id = :id", nativeQuery = true)
    Optional<Reason> getReason(@Param("id") Integer id);


    /**
     * Create by: GiangLBH
     * Date created: 17/12/2022
     * Function: to write Reason when do not review
     *
     * @Param reason
     */
    @Modifying
    @Query(value = "insert into reason (product_id, reason) " +
            "values (:#{#reason.productId}, :#{#reason.reason})", nativeQuery = true)
    void addReason(@Param("reason") Reason reason);
}