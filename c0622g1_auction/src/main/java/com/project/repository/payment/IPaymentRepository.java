package com.project.repository.payment;

import com.project.dto.IPaymentDto;
import com.project.model.payment.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

    @Query(value = "select payment.shipping_description as ShippingDescription,user.email,user.phone,user.first_name as firstName,user.last_name as lastName,product.id,product.initial_price as initialPrice,product.name as productName,address.city, " +
            "address.country,address.detail_address  as detailAddress,address.district,address.town from payment join user on " +
            "user.id = payment.user_id join address on address.id = user.address_id join  auction on " +
            "auction.user_id = user.id  join product on product.id = auction.product_id where payment_status = 0",nativeQuery = true,
            countQuery = "select payment.shipping_description,user.email,user.phone,user.first_name,user.last_name,product.id,product.price,product.name,address.city, " +
                    "address.count,address.detail_address,address.district,address.town from payment join user on " +
                    "user.id = payment.user_id join address on address.id = user.address_id join  auction on " +
                    "auction.user_id = user.id  join product on product.id = auction.product_id where payment_status = 0")
    Page<IPaymentDto> showPayment (Pageable pageable);

    @Query(value = "select payment.shipping_description as ShippingDescription,user.email,user.phone,user.first_name as firstName ,user.last_name as lastName,product.id,product.price,product.name,address.city,address.count,address.detail_address as detailAddress,address.district,address.town from payment join user on user.id = payment.user_id join address on address.id = user.address_id join  auction on auction.user_id = user.id  join product on product.id = auction.product_id where payment_status = 0 and product.id = :id",nativeQuery = true)
    IPaymentDto findId(@Param("id") Integer id);
}
