package com.project.repository.auction;

import com.project.model.auction.Auction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IAuctionRepository extends JpaRepository<Auction, Integer> {

    /**
     * Created by : HuyNV,
     * Date created: 13/12/2022
     * Function: to list and search transaction
     *
     * @return HttpStatus.NO_CONTENT
     * @return HttpStatus.OK
     */

    @Query(value = "select * from auction_web.auction ", nativeQuery = true)
    Page<Auction> findAllTransaction(Pageable pageable);

    /**
     * Created by : HuyNV
     * Date created: 14/12/2022
     * Function: to delete transaction by List ids
     *
     * @param idList
     */
    @Modifying
    @Query(value = "update auction_web.auction set delete_status = 1 where id in :idList ", nativeQuery = true)
    void removeByListId(@Param("idList") List<Integer> idList);

    /**
     * Created by : HuyNV
     * Date Created: 14/12/2022
     * Function: to find transaction by List ids
     *
     * @param idList
     * @return transaction list
     */
    @Query(value = "select * from auction_web.auction where id in :idList and delete_status = 0 ", nativeQuery = true)
    List<Auction> findByListId(@Param("idList") List<Integer> idList);
}
