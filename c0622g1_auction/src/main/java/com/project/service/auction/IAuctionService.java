package com.project.service.auction;

import com.project.dto.auction.TransactionListDto;
import com.project.dto.auction.TransactionSearchDto;
import com.project.model.auction.Auction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAuctionService {

    Page<TransactionListDto> findAll(TransactionListDto transactionListDto, Pageable pageable);


    /**
     * Created by : HuyNV,
     * Date created: 13/12/2022
     * Function: to list and search transaction
     *
     * @param pageable
     * @return
     */
    Page<Auction> findAllTransaction(TransactionSearchDto transactionSearchDto, Pageable pageable);

    /**
     * Created by : HuyNV
     * Date created: 14/12/2022
     * Function: to delete transaction by List ids
     *
     * @param idList
     */
    void removeByListId(List<Integer> idList);

    /**
     * Created by : HuyNV
     * Date Created: 14/12/2022
     * Function: to find transaction by List ids
     *
     * @param idList
     * @return
     */
    List<Auction> findByListId(List<Integer> idList);
}
