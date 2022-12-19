package com.project.repository.product;

import com.project.model.product.AuctionStatus;
import com.project.model.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IPriceRangeRepository extends JpaRepository<AuctionStatus,Integer> {
    /**
     * Created by: GiangLBH
     * Date created: 17-12-2022
     * Function: get all Auction Status
     * @return Auction status list
     */
    @Query(value = "SELECT * FROM auction_status", nativeQuery = true)
    List<AuctionStatus> getListAuctionStatus();

}
