package com.project.service.product.impl;

import com.project.model.product.AuctionStatus;
import com.project.repository.product.IAuctionStatusRepository;
import com.project.service.product.IAuctionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionStatusService implements IAuctionStatusService {
    @Autowired
    private IAuctionStatusRepository auctionStatusRepository;

    @Override
    public List<AuctionStatus> findAuctionStatus() {
        return auctionStatusRepository.getListAuctionStatus();
    }

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: find all Auction status of Auction
     * @return: List Auction Status of Auction
     */
    @Override
    public AuctionStatus getAuctionStatus(Integer auctionStatus) {
        return auctionStatusRepository.findById(auctionStatus).orElse(null);
    }
}
