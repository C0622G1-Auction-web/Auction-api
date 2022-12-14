package com.project.repository.payment;


import com.project.dto.IPaymentDto;
import com.project.model.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {
    @Query(value = "select auction.current_price as currentPrice" +
                   " from auction" +
                   " join  payment on payment.auction_id = auction.id " +
                   " join user  on user.id = auction.user_id where payment.id=:id" +
                   " and payment.payment_status = 0",
                     nativeQuery = true)
    IPaymentDto getPrice(@Param("id") Integer id);


}
