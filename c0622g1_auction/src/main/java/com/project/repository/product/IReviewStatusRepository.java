package com.project.repository.product;

import com.project.model.product.ReviewStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IReviewStatusRepository extends JpaRepository<ReviewStatus,Integer> {
}
