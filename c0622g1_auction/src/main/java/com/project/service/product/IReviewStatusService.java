package com.project.service.product;

import com.project.model.product.ReviewStatus;

import java.util.List;

public interface IReviewStatusService {
    /**
 * Created by: AnhTDQ,
 * Date created: 15/12/2022
 * Function: get list review status of product auctions
 * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
 */

  List<ReviewStatus> findAll();
}
