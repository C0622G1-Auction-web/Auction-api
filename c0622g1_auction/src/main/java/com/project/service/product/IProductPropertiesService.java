package com.project.service.product;

import com.project.model.product.AuctionStatus;
import com.project.model.product.Reason;
import com.project.model.product.SearchProductRange;

import java.util.List;
import java.util.Optional;

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

    /**
     * Create by: GiangLBH
     * Date created: 17/12/2022
     * Function: to write Reason when do not review
     *
     * @Param reason
     */
    void addReason(Reason reason);

    /**
     * Create by: GiangLBH
     * Date created: 17/12/2022
     * Function: to get Reason when do not review
     *
     * @Return reason
     */
    Optional<Reason> getReason(Integer id);
}
