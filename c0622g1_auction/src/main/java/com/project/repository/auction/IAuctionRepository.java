package com.project.repository.auction;

import com.project.dto.IAuctionDto;
import com.project.model.auction.Auction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IAuctionRepository extends JpaRepository<Auction,Integer> {

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: get page auction by product id
     * order DESC current price
     * @param productId
     * @param pageable
     * @return HttpStatus.OK if result is not empty
     * @return HttpStatus.NO_CONTENT if result is empty
     */

    @Query(value = "select a.id auctionId, a.auction_day auctionDay, a.current_price currentPrice, concat(u.first_name,\" \",u.last_name) fullName  from `auction` a join `user` u on a.user_id = u.id where a.product_id=:productId and a.delete_status = 0 order by a.current_price desc",nativeQuery = true)
    Page<IAuctionDto> getPageAuctionByProductId(@Param("productId") Integer productId, Pageable pageable);
}
