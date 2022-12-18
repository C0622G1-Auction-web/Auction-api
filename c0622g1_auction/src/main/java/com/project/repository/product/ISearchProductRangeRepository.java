package com.project.repository.product;

import com.project.model.product.SearchProductRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISearchProductRangeRepository extends JpaRepository<SearchProductRange, Integer> {
    /**
     * Created by: GiangLBH
     * Date created: 17-12-2022
     * Function: get List Search Product Ranges
     *
     * @return Auction status list
     */
    @Query(value = "SELECT * FROM search_product_range", nativeQuery = true)
    List<SearchProductRange> getListSearchProductRanges();

}
