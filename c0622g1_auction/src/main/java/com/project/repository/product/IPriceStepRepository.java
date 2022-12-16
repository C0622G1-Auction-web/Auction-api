package com.project.repository.product;

import com.project.model.product.PriceStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPriceStepRepository extends JpaRepository<PriceStep,Integer> {

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: get all price step
     * @return price step list
     */
    @Query(value = "select * from price_step", nativeQuery = true)
    List<PriceStep> getPriceStep();
}
