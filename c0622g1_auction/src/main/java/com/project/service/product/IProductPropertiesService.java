package com.project.service.product;

import com.project.model.product.AuctionStatus;
import com.project.model.product.SearchProductRange;

import java.util.List;

public interface IProductPropertiesService {

    /**
     * Create by: GiangLBH
     * Date created: 17/12/2022
     * Function: to find all searchProductRange list
     *
     * @return searchProductRange list
     */
    List<SearchProductRange> getListSearchProductRange();

    /**
     * Create by: GiangLBH
     * Date created: 17/12/2022
     * Function: to find all AuctionStatus list
     *
     * @return AuctionStatus list
     */
    List<AuctionStatus> getListAuctionStatus();

}
