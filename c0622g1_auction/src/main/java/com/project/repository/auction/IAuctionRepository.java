package com.project.repository.auction;

import com.project.dto.product.IAuctionProductDto;
import com.project.model.auction.Auction;
import com.project.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
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
     * Created by: AnhTDQ,
     * Date created: 13/12/2022
     * Function: get page auction product by product id
     *
     * @param 'user ID'
     * @param 'pageable'
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */
    @Query(value = " select `user`.id as idUser,product.name as nameProduct ,product.description as description " +
            ",auction.current_price as priceNow , product.register_day as registerDay, auction_status.name as auctionStatus " +
            "   from auction " +
            "   join `user` on auction.user_id = `user`.id " +
            "   join product on auction.product_id = product.id " +
            "   join  auction_status on product. auction_status_id =  auction_status.id " +
            "   where auction.user_id = :userId",nativeQuery = true)

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
