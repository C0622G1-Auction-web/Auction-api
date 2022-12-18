package com.project.repository.auction;

import com.project.dto.auction.TransactionListDto;
import com.project.dto.auction.TransactionSearchDto;
import com.project.model.auction.Auction;
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
public interface IAuctionRepository extends JpaRepository<Auction, Integer> {

    /**
     * Created by : HuyNV,
     * Date created: 13/12/2022
     * Function: to list and search transaction
     *
     * @return HttpStatus.NO_CONTENT
     * @return HttpStatus.OK
     */

    @Query(value = "select auc.* " +
            "        from `auction` auc join `product` pt " +
            "        on auc.product_id = pt.id " +
            "        join `user` ur on pt.user_id = ur.id " +
            "        join `view_user` vw on auc.user_id = vw.id " +
            "        where auc.delete_status = 0 " +
            "        and concat(ur.first_name,' ', ur.last_name) like %:#{#transactionSearchDto.userPost}% " +
            "        and concat(vw.first_name,' ', vw.last_name) like %:#{#transactionSearchDto.userBuying}% " +
            "        and pt.name like %:#{#transactionSearchDto.nameProduct}% " +
            "        and auc.current_price >= :#{#transactionSearchDto.currentPrice} " +
            "        and auc.pay_status like %:#{#transactionSearchDto.payStatus}% ", nativeQuery = true)
    Page<Auction> findAllTransaction(@Param("transactionSearchDto") TransactionSearchDto transactionSearchDto,
            Pageable pageable);

    @Query(value = "select auction.id ,auction.auction_day,product.name,auction.auction_time,auction.current_price,auction.auction_status,concat(`user`.first_name, \" \", `user`.last_name) as \"Người đăng\", \n" +
            "concat(view_user.first_name, \" \", view_user.last_name) as \"Người mua\"\n" +
            "        from auction_web.auction join product \n" +
            "        on `auction`.product_id = product.id \n" +
            "        join `user` on product.user_id = `user`.id \n" +
            "        join view_user on `auction`.user_id = view_user.id \n" +
            "        where `auction`.delete_status = 0 ",nativeQuery = true)
    Page<TransactionListDto> findAll(TransactionListDto transactionListDto, Pageable pageable);


    /**
     * Created by : HuyNV
     * Date created: 14/12/2022
     * Function: to delete transaction by List ids
     *
     * @param idList
     */
    @Modifying
    @Query(value = "update auction_web.auction set delete_status = 1 where id in :idList ", nativeQuery = true)
    void removeByListId(@Param("idList") List<Integer> idList);

    /**
     * Created by : HuyNV
     * Date Created: 14/12/2022
     * Function: to find transaction by List ids
     *
     * @param idList
     * @return transaction list
     */
    @Query(value = "select * from auction_web.auction where id in :idList and delete_status = 0 ", nativeQuery = true)
    List<Auction> findByListId(@Param("idList") List<Integer> idList);


}
