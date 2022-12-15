package com.project.controller.auction;

import com.project.service.auction.impl.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auction")
@CrossOrigin("*")
public class AuctionRestController {

    @Autowired
    private AuctionService auctionService;



}
