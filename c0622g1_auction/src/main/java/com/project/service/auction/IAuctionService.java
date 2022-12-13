package com.project.service.auction;

import com.project.model.auction.Auction;

import java.util.List;

public interface IAuctionService {
    List<Auction> findAllTransaction();
}
