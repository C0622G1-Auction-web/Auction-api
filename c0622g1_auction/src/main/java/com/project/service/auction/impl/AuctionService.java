package com.project.service.auction.impl;

import com.project.dto.IAuctionProductDto;
import com.project.repository.auction.IAuctionRepository;
import com.project.service.auction.IAuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class AuctionService implements IAuctionService {
    @Autowired
    private IAuctionRepository auctionRepository;

    @Override
    public Page<IAuctionProductDto> getPageAuctionProductByUserId(Integer userId, Pageable pageable) {
        return auctionRepository.getPageAuctionProductByIdUser(userId,pageable);
    }
}
