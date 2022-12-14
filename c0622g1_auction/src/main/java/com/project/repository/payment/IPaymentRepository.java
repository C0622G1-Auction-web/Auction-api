package com.project.repository.payment;

import com.project.dto.IPaymentDTO;
import com.project.model.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

    /**
     * Created by: ChauPTM
     * Date created: 13/12/2022
     * Function: to find payment by id
     *
     * @param id
     * @return HttpStatus.NO_CONTENT
     * @return HttpStatus.OK
     */

    @Query(value = "SELECT p.id AS code, sum(us.last_name + us.first_name) AS name, ad.city, ad.district, " +
            "ad.detail_address AS address , ad.country, pr.name AS productName, au.current_price AS productPrice," +
            " pr.description AS des, sum(au.current_price) AS total " +
            "FROM payment AS p \n" +
            "JOIN auction AS au ON p.auction_id = au.id " +
            "JOIN product AS pr ON au.product_id = pr.id\n" +
            "JOIN user AS us ON au.user_id = us.id\n" +
            "JOIN address AS ad ON us.address_id " +
            "WHERE p.id = :id AND p.payment_status = 1 AND p.delete_status = 1", nativeQuery = true, countQuery = "select count(*) from payment")
    Optional<IPaymentDTO> findByIdPayment(@Param("id") Integer id);


}
