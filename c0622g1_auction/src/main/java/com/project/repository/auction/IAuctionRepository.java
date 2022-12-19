package com.project.repository.auction;

import com.project.dto.auction.ITransactionDto;
import com.project.dto.auction.TransactionSearchDto;
import com.project.dto.product.IAuctionProductDto;
import com.project.model.auction.Auction;
import com.project.model.product.Product;
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
     * @return HttpStatus.OK
     */

    @Query(value = " select auc.id as id, " +
            "            auc.auction_day as auctionDay, " +
            "            pt.name as productName, " +
            "            auc.current_price as currentPrice," +
            "            auc.auction_status as auctionStatus," +
            "            auc.delete_status as deleteStatus," +
            "            concat(ur.first_name,' ', ur.last_name) as userPost, " +
            "            concat(vw.first_name,' ', vw.last_name) as userBuying " +
            "            from `auction` auc join `product` pt " +
            "            on auc.product_id = pt.id " +
            "            join `user` ur on pt.user_id = ur.id " +
            "            join `view_user` vw on auc.user_id = vw.id " +
            "            where auc.delete_status = 0 " +
            "            and concat(ur.first_name,' ', ur.last_name) like %:#{#transactionSearchDto.userBuying} " +
            "            and concat(vw.first_name,' ', vw.last_name) like %:#{#transactionSearchDto.userPost}% " +
            "            and pt.name like %:#{#transactionSearchDto.nameProduct}% " +
            "            and auc.current_price >= :#{#transactionSearchDto.currentPrice} " +
            "            and auc.auction_status like %:#{#transactionSearchDto.auctionStatus}%  ", nativeQuery = true)
    Page<ITransactionDto> findAllTransaction(@Param("transactionSearchDto") TransactionSearchDto transactionSearchDto,
                                             Pageable pageable);

    /**
     * Created by : HuyNV
     * Date created: 14/12/2022
     * Function: to delete transaction by List ids
     *
     * @param idList
     */
    @Modifying
    @Query(value = "update auction_web_system_v3.auction set delete_status = 1 where id in :idList ", nativeQuery = true)
    void removeByListId(@Param("idList") List<Integer> idList);

    /**
     * Created by : HuyNV
     * Date Created: 14/12/2022
     * Function: to find transaction by List ids
     *
     * @param idList
     * @return transaction list
     */
    @Query(value = " select auc.id as id, " +
            "            auc.auction_day as auctionDay, " +
            "            pt.name as productName, " +
            "            auc.current_price as currentPrice," +
            "            auc.auction_status as auctionStatus," +
            "            auc.delete_status as deleteStatus," +
            "            concat(ur.first_name,' ', ur.last_name) as userPost, " +
            "            concat(vw.first_name,' ', vw.last_name) as userBuying " +
            "            from `auction` auc join `product` pt " +
            "            on auc.product_id = pt.id " +
            "            join `user` ur on pt.user_id = ur.id " +
            "            join `view_user` vw on auc.user_id = vw.id " +
            "            where auc.delete_status = 0 and auc.id in :idList ", nativeQuery = true)
    List<ITransactionDto> findByListId(@Param("idList") List<Integer> idList);

    @Query(value = "select product.name, product.description,auction.auction_day,auction_status.name " +
            "from auction " +
            "join user on auction.user_id = user.id " +
            "join product on auction.product_id = product.id " +
            "join auction_status on product.auction_status_id = auction_status.id " +
            "where auction.user_id = :id ", nativeQuery = true)
    List<Product> showProductAuctionById(@Param("id") int id);

    /**
     * Created by: AnhTDQ,
     * Date created: 13/12/2022
     * Function: get page auction product by product id
     *
     * @param 'user      ID'
     * @param 'pageable'
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */
    @Query(value = " select `user`.id as idUser,product.name as nameProduct ,product.description as description " +
            ",auction.current_price as priceNow , product.register_day as registerDay, auction_status.name as auctionStatus " +
            "   from auction " +
            "   join `user` on auction.user_id = `user`.id " +
            "   join product on auction.product_id = product.id " +
            "   join  auction_status on product. auction_status_id =  auction_status.id " +
            "   where auction.user_id = :userId",
            countQuery = "count (*) from auction" +
                    "   join `user` on auction.user_id = `user`.id " +
                    "   join product on auction.product_id = product.id " +
                    "   join  auction_status on product. auction_status_id =  auction_status.id " +
                    "   where auction.user_id = :userId", nativeQuery = true)
    Page<IAuctionProductDto> getPageAuctionProductByIdUser(@Param("userId") Integer userId, Pageable pageable);

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: get page auction by product id
     *
     * @param productId
     * @param pageable
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */
    @Query(value = "select a.*  from `auction` a where a.product_id=:productId and a.delete_status = 1 order by a.current_price desc", nativeQuery = true)
    Page<Auction> getPageAuctionByProductId(@Param("productId") Integer productId, Pageable pageable);


    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: find product by id
     *
     * @return HttpStatus.BAD_REQUEST if result is error or HttpStatus.OK if result is not error
     * @param: auctionDay, currentPrice, productId, userId
     */
    @Modifying
    @Query(value = "insert into `auction` (auction_time ,current_price, product_id, user_id) " +
            "values (now(), :currentPrice, :productId, :userId)", nativeQuery = true)
    void addAuction(@Param("currentPrice") Double currentPrice,
                    @Param("productId") Integer productId,
                    @Param("userId") Integer userId);
}
