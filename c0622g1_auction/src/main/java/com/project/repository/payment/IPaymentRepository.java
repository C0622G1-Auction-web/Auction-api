package com.project.repository.payment;

import com.project.dto.payment.IPaymentAddressDto;
import com.project.dto.payment.IPaymentDto;
import com.project.dto.payment.IPaymentTotalBillDto;
import com.project.model.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
            "            ad.town AS town, ad.detail_address AS detailAddress , ad.country, pr.name AS productName, au.current_price AS productPrice,\n" +
            "            pr.description, img.url as productImage\n" +
            "            FROM payment AS p \n" +
            "            JOIN auction AS au ON p.auction_id = au.id  \n" +
            "            JOIN product AS pr ON au.product_id = pr.id\n" +
            "            JOIN user AS us ON au.user_id = us.id\n" +
            "            JOIN address AS ad ON us.address_id = ad.id\n" +
            "            JOIN img_url_product as img on img.product_id = pr.id\n" +
            "            WHERE us.id =3\n" +
            "            AND p.payment_status = 0 \n" +
            "            AND p.delete_status = 0 \n" +
            "            AND au.auction_status = 1 group by p.id;", nativeQuery = true)
    List<IPaymentDto> findValidPaymentByUserId(@Param(value = "user_id") String userId);

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
            "AND au.auction_status = 1 group by p.id", nativeQuery = true, countQuery = "select count(*) from payment")
    Optional<IPaymentDto> findPaymentIdByDTO(@Param("id") Integer id);

   /**
     * Created by: ChauPTM
     * Date created: 13/12/2022
     * Function: to find payment by id
     *
     * @param id
     * @return Payment
     */
    @Query(value = " SELECT * FROM payment WHERE payment_status = 0 AND id = :id ", nativeQuery = true)
    Payment findPaymentById(@Param("id") Integer id);

    /**
     * Create by: BaoBC
     * Date created: 14/12/2022
     * Function: to find payment by List ids
     *
     * @param idList
     * @return product list
     */

    @Query(value = "select address.city, address.country, address.detail_address as detailAddress ,address.district," +
            "address.town,user.email, user.first_name as firstName,user.last_name as lastName,user.phone," +
            "payment.shipping_description  as description ,payment.id, pr.name as productName, auction.current_price as productPrice " +
            " from user " +
            " join address on address.id = user.address_id " +
            " join auction on auction.user_id = user.id " +
            " join payment on payment.auction_id = auction.id" +
            " join product as pr on pr.id = auction.product_id  " +
            " where payment.id in :idList and payment.payment_status = 0" +
            " and payment.delete_status = 0", nativeQuery = true)
    List<IPaymentAddressDto> findByListId(@Param("idList") List<Integer> idList);


    /**
     * Create by: BaoBC
     * Date created: 14/12/2022
     * Function: update shippingDescription payment by id payment
     *
     * @param idList
     * @return product list
     */
    @Modifying
    @Query(value = "update payment set shipping_description = :shippingDescription where id in :idList", nativeQuery = true)
    void updateByListId(@Param("idList") List<Integer> idList,
                         @Param("shippingDescription") String shippingDescription);

    /**
     * Create by: BaoBC
     * Date created: 15/12/2022
     * Function: to get total bill
     *
     * @param idList
     * @return
     */

    @Query(value = "select sum(auction.current_price) as totalBill "+
            "from user " +
            " join address on address.id = user.address_id " +
            " join auction on auction.user_id = user.id " +
            " join payment on payment.auction_id = auction.id where payment.id in :idList and payment.payment_status = 0" +
            " and payment.delete_status = 0", nativeQuery = true)
    IPaymentTotalBillDto getTotalBill(@Param("idList") List<Integer> idList);

}
