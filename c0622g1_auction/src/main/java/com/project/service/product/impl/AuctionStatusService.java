package com.project.service.product.impl;

import com.project.repository.product.IAuctionStatusRepository;
import com.project.service.product.IAuctionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionStatusService implements IAuctionStatusService {
    @Autowired
    private IAuctionStatusRepository auctionStatusRepository;
}
