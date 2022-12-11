package com.project.repository.product;

import com.project.model.product.PriceStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IPriceStepRepository extends JpaRepository<PriceStep,Integer> {
}
