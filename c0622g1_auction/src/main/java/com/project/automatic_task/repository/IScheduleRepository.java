package com.project.automatic_task.repository;

import com.project.automatic_task.dto.IPaymentCheckDto;
import com.project.automatic_task.dto.IProductTimeDto;
import com.project.automatic_task.dto.ITopAuctionDetailDto;
import com.project.model.payment.Payment;
import com.project.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IScheduleRepository extends JpaRepository<Product, Integer> {

    /**
     * Create by: GiangLBH
     * Date created: 25/12/2022
     * Function: get ProductDto to check Start time
     *
     * @Return List Product Dto
     */
    @Query(value = "select product.id as id, " +
            "product.start_time as startTime, " +
            "product.end_time as endTime " +
            "from product " +
            "where delete_status = 0 " +
            "and review_status_id = 2 " +
            "and auction_status_id = 1 " +
            "and start_time < current_timestamp();", nativeQuery = true)
    List<IProductTimeDto> checkStartTime();

    /**
     * Create by: GiangLBH
     * Date created: 25/12/2022
     * Function: to open Auction
     *
     * @param id
     */
    @Transactional
    @Modifying
    @Query(value = "update `product` set auction_status_id = 2 where id = :id ", nativeQuery = true)
    void openAuction(@Param("id") Integer id);

    /**
     * Create by: GiangLBH
     * Date created: 25/12/2022
     * Function: get ProductDto to check end time
     *
     * @Return List Product Dto
     */
    @Query(value = "select product.id as id, " +
            "product.start_time as startTime, " +
            "product.end_time as endTime " +
            "from product " +
            "where delete_status = 0 " +
            "and review_status_id = 2 " +
            "and auction_status_id = 2 " +
            "and end_time < current_timestamp() ", nativeQuery = true)
    List<IProductTimeDto> checkEndTime();

    /**
     * Create by: GiangLBH
     * Date created: 25/12/2022
     * Function: get success Auction
     *
     * @Param product id
     * @Return success Auction
     */
    @Query(value = "select " +
            "id as auctionId, " +
            "user_id as userId, " +
            "product_id as productId, " +
            "auction_time as auctionTime, " +
            "current_price as price " +
            "from auction " +
            "where product_id = :id " +
            "order by current_price " +
            "desc limit 1 ", nativeQuery = true)
    ITopAuctionDetailDto findSuccessAuction(@Param("id") Integer id);

    /**
     * Create by: GiangLBH
     * Date created: 25/12/2022
     * Function: to set success status for Product
     *
     * @param id
     */
    @Transactional
    @Modifying
    @Query(value = "update `product` set auction_status_id = 3 where id = :id ", nativeQuery = true)
    void setSuccessProduct(@Param("id") Integer id);


    /**
     * Create by: GiangLBH
     * Date created: 25/12/2022
     * Function: to set failure status for Product
     *
     * @param id
     */
    @Transactional
    @Modifying
    @Query(value = "update `product` set auction_status_id = 4 where id = :id ", nativeQuery = true)
    void setFailureProduct(@Param("id") Integer id);

    /**
     * Create by: GiangLBH
     * Date created: 25/12/2022
     * Function: to set success status for Auction
     *
     * @param auctionId
     */
    @Transactional
    @Modifying
    @Query(value = "update `auction` set auction_status = 1 where id = :auctionId ", nativeQuery = true)
    void setSuccessAuction(@Param("auctionId") Integer auctionId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `payment` " +
            "(delete_status, payment_status, auction_id) " +
            "VALUES " +
            "(0, 1, :auctionId) ",
            nativeQuery = true)
    void createPayment(@Param("auctionId") Integer auctionId);

    /**
     * Create by: GiangLBH
     * Date created: 25/12/2022
     * Function: get list payment out of end time
     *
     * @Return List payment dto
     */
    @Query(value = "select pmt.id as paymentId, " +
            "auc.user_id as buyerId, " +
            "pt.user_id as sellerId, " +
            "auc.current_price as price, " +
            "pt.end_time as endTime " +
            "from `payment` pmt " +
            "join `auction` auc on pmt.auction_id = auc.id " +
            "join `product` pt on pt.id = auc.product_id " +
            "where pmt.delete_status = 0 and pmt.payment_status = 1 " +
            "and (pt.end_time + INTERVAL 1 DAY) < current_timestamp();", nativeQuery = true)
    List<IPaymentCheckDto> getPaymentOutOfEndDate();

    /**
     * Create by: GiangLBH
     * Date created: 25/12/2022
     * Function: to set failure status for payment
     *
     * @param paymentId
     */
    @Transactional
    @Modifying
    @Query(value = "update `payment` set payment_status = 0 where id = :paymentId ", nativeQuery = true)
    void setFailurePayment(@Param("paymentId") Integer paymentId);

    /**
     * Create by: GiangLBH
     * Date created: 25/12/2022
     * Function: to lock account buyer
     *
     * @param buyerId
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE `auction_web_system_v3`.`account` SET `status_lock` = '0' WHERE `id` = :buyerId ", nativeQuery = true)
    void lockAccount(@Param("buyerId") Integer buyerId);

//    @Transactional
//    @Modifying
//    @Query(value = "INSERT INTO `lock_account` ( `start_day`,`end_day`, `reason`, `account_id`) " +
//            " VALUES (current_timestamp(), current_timestamp() + INTERVAL 1 year, 'Không thanh toán khi đấu giá thành công', :buyerId) ", nativeQuery = true)
//    void lockAccount(@Param("buyerId") Integer buyerId);
}
