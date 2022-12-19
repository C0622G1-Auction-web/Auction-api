package com.project.repository.product;

import com.project.model.product.ReviewStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReviewStatusRepository extends JpaRepository<ReviewStatus, Integer> {

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: get all review status
     *
     * @return review status list
     */
    @Query(value = "select * from review_status", nativeQuery = true)
    List<ReviewStatus> getReviewStatus();
}
