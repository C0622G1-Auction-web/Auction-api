package com.project.service.product;

import com.project.model.auction.Auction;
import com.project.model.product.AuctionStatus;
import com.project.model.product.PriceStep;
import com.project.model.product.ReviewStatus;

import java.util.List;

public interface IAuctionStatusService {
    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: find all Auction Status
     */
    List<AuctionStatus> findAuctionStatus();

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * @Param: int ID of Auction Status
     * Function: get Auction Status of Product
     */

    AuctionStatus getAuctionStatus(Integer auctionStatus);
}
