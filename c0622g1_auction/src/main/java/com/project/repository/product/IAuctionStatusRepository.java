package com.project.repository.product;

import com.project.model.product.AuctionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IAuctionStatusRepository extends JpaRepository<AuctionStatus,Integer> {
    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: get all auction status
     * @return auction status list
     */
    @Query(value = "SELECT * FROM auction_status", nativeQuery = true)
    List<AuctionStatus> listAuctionStatus();
}
