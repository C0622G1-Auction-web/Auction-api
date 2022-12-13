package com.project.repository.auction;

import com.project.model.auction.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IAuctionRepository extends JpaRepository<Auction,Integer> {

    /**
     * Created by : HuyNV,
     * Date created: 13/12/2022
     * Function: to list and search transaction
     * @return HttpStatus.NO_CONTENT
     * @return HttpStatus.OK
     */

    @Query(value = "SELECT * FROM auction_web.auction", nativeQuery = true)
    List<Auction> findAll();
}
