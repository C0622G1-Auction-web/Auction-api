package com.project.service.product;

import com.project.model.product.PriceStep;
import com.project.model.product.ReviewStatus;

import java.util.List;

import com.project.model.product.ReviewStatus;

import java.util.List;

public interface IReviewStatusService {
    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: find all Review Status
     */
    List<ReviewStatus> findReviewStatus();

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * @Param: int ID of Review Status
     * Function: get Review Status of Product
     */

    ReviewStatus getReviewStatus(Integer reviewStatus);
    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function: get list review status of product auctions
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */

    List<ReviewStatus> findAll();
}