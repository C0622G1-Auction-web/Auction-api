package com.project.service.auction.impl;

import com.project.dto.auction.TransactionSearchDto;
import com.project.model.auction.Auction;
import com.project.repository.auction.IAuctionRepository;
import com.project.service.auction.IAuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService implements IAuctionService {
    @Autowired
    private IAuctionRepository auctionRepository;


    /**
     * Created by : HuyNV,
     * Date created: 13/12/2022
     * Function: to list and search transaction
     *
     * @return HttpStatus.OK
     */

    @Override
    public Page<Auction> findAllTransaction(TransactionSearchDto transactionSearchDto, Pageable pageable) {
        return auctionRepository.findAllTransaction(transactionSearchDto, pageable);
    }

    /**
     * Created by : HuyNV
     * Date created: 14/12/2022
     * Function: to delete transaction by List ids
     *
     * @param idList
     */
    @Override
    public void removeByListId(List<Integer> idList) {
        auctionRepository.removeByListId(idList);
    }


    /**
     * Created by : HuyNV
     * Date Created: 14/12/2022
     * Function: to find transaction by List ids
     *
     * @param idList
     * @return
     */
    @Override
    public List<Auction> findByListId(List<Integer> idList) {
        return auctionRepository.findByListId(idList);
    }
}
