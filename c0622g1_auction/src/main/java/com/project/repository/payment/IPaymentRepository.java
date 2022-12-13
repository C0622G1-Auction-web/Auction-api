package com.project.repository.payment;

import com.project.model.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {
    /**Created by UyenNC
     * Date created 13/12/2022
     * Function Find valid payment by user id
     * @param userId
     * @return List<Payment>
     */
    @Query(value = "select payment.* from payment\n" +
            "join auction on payment.auction_id = auction.id\n" +
            "where payment.delete_status = 0 and payment.payment_status = 0 and auction.auction_status = 0 and auction.user_id =:user_id", nativeQuery = true)
    List<Payment> findValidPaymentByUserId(@Param(value = "user_id") String userId);
}
