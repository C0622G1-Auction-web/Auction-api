package com.project.repository.auction;

import com.project.model.auction.Auction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IAuctionRepository extends JpaRepository<Auction, Integer> {

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: get page auction by product id
     * @param productId
     * @param pageable
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */

   @Query(value = "select a.*  from `auction` a where a.product_id=:productId and a.delete_status = 0 order by a.current_price desc", nativeQuery = true)
    Page<Auction> getPageAuctionByProductId(@Param("productId") Integer productId, Pageable pageable);


    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: find product by id
     * @param: auctionDay, currentPrice, productId, userId
     * @return HttpStatus.BAD_REQUEST if result is error or HttpStatus.OK if result is not error
     */

    @Modifying
    @Query(value = "insert into `auction` (auction_day ,current_price, product_id, user_id) " +
            "values (now(), :currentPrice, :productId, :userId)", nativeQuery = true)
    void addAuction(@Param("currentPrice") Double currentPrice,
                    @Param("productId") Integer productId,
                    @Param("userId") Integer userId);
}
