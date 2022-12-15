package com.project.service.auction.impl;

import com.project.model.product.Product;
import com.project.repository.auction.IAuctionRepository;
import com.project.service.auction.IAuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService implements IAuctionService {
    @Autowired
    private IAuctionRepository auctionRepository;

    @Override
    public List<Product> showProductAuctionById(int id) {
        return auctionRepository.showProductAuctionById(id);
    }
}
