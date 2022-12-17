package com.project.service.auction;

import com.project.dto.AuctionDto;
import com.project.dto.product.IAuctionProductDto;
import com.project.model.auction.Auction;
import com.project.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAuctionService {


    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: get page auction by product id
     *
     * @param productId
     * @param pageable
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */
    Page<Auction> getPageAuctionByProductId(Integer productId, Pageable pageable);

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: Add Auction
     *
     * @param auctionDto
     * @return HttpStatus.BAD_REQUEST if result is error or HttpStatus.OK if result is not error
     */
    void addAuction(AuctionDto auctionDto);


    /**
     * Created by: AnhTDQ,
     * Date created: 13/12/2022
     * Function: get page auction product by product id
     *
     * @param 'userId'
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */

    Page<IAuctionProductDto> getPageAuctionProductByUserId(Integer userId, Pageable pageable);
}
