package com.project.service.product.impl;

import com.project.model.product.ReviewStatus;
import com.project.repository.product.IReviewStatusRepository;
import com.project.service.product.IReviewStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewStatusService implements IReviewStatusService {
    @Autowired
    private IReviewStatusRepository reviewStatusRepository;

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: find all Review Status of Product
     * @return: List Review Status of Product
     */

    @Override
    public List<ReviewStatus> findReviewStatus() {
        return reviewStatusRepository.getReviewStatus();
    }

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: save Review Status of Product
     * @return: Review Status of Product
     */

    @Override
    public ReviewStatus getReviewStatus(Integer reviewStatus) {
        return reviewStatusRepository.findById(reviewStatus).orElse(null);
    }
}
