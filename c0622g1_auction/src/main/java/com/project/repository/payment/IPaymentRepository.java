package com.project.repository.payment;

import com.project.dto.IPaymentDTO;
import com.project.model.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

    /**Created by UyenNC
     * Date created 13/12/2022
     * Function Find valid payment by user id
     * @param userId
     * @return List<IPaymentDTO>
     */
    @Query(value = "SELECT p.id AS code, us.last_name AS lastName , us.first_name AS firstName, ad.city, ad.district, \n" +
            "            ad.detail_address AS address , ad.country, pr.name AS productName, au.current_price AS productPrice,\n" +
            "            pr.description, pr.id  as productId\n" +
            "            FROM payment AS p \n" +
            "            JOIN auction AS au ON p.auction_id = au.id  \n" +
            "            JOIN product AS pr ON au.product_id = pr.id\n" +
            "            JOIN user AS us ON au.user_id = us.id\n" +
            "            JOIN address AS ad ON us.address_id \n" +
            "            WHERE us.id =:user_id \n" +
            "            AND p.payment_status = 0 \n" +
            "            AND p.delete_status = 0 \n" +
            "            AND au.auction_status = 1 group by p.id;", nativeQuery = true)
    List<IPaymentDTO> findValidPaymentByUserId(@Param(value = "user_id") String userId);

    /**
     * Created by: ChauPTM
     * Date created: 13/12/2022
     * Function: to find payment by id using DTO
     *
     * @param id
     * @return PaymentDTO
     */
    @Query(value = "SELECT p.id AS code, us.last_name AS lastName , us.first_name AS firstName, ad.city, ad.district, " +
            "ad.detail_address AS address , ad.country, pr.name AS productName, au.current_price AS productPrice," +
            " pr.description " +
            "FROM payment AS p \n" +
            "JOIN auction AS au ON p.auction_id = au.id " +
            "JOIN product AS pr ON au.product_id = pr.id\n" +
            "JOIN user AS us ON au.user_id = us.id\n" +
            "JOIN address AS ad ON us.address_id " +
            "WHERE p.id = :id " +
            "AND p.payment_status = 0 " +
            "AND p.delete_status = 0 " +
            "AND au.auction_status = 1 group by us.id", nativeQuery = true, countQuery = "select count(*) from payment")
    Optional<IPaymentDTO> findPaymentIdByDTO(@Param("id") Integer id);

   /**
     * Created by: ChauPTM
     * Date created: 13/12/2022
     * Function: to find payment by id
     *
     * @param id
     * @return Payment
     */
    @Query(value = "SELECT payment.* FROM payment WHERE payment_status = 0 AND id =:id", nativeQuery = true)
    Payment findPaymentById(@Param("id") Integer id);

}
