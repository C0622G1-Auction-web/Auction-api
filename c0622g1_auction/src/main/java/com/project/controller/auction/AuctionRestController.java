package com.project.controller.auction;

import com.project.model.auction.Auction;
import com.project.service.auction.IAuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/auction/v1")
public class AuctionRestController {
    @Autowired
    private IAuctionService auctionService;

    /**
     * Created by : HuyNV,
     * Date created: 13/12/2022
     * Function: to list and search transaction
     * @return HttpStatus.NO_CONTENT
     * @return HttpStatus.OK
     */
    @GetMapping
    public ResponseEntity<List<Auction>> getTransactionList(){
        List<Auction> transactionList = auctionService.findAllTransaction();
        if (transactionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transactionList, HttpStatus.OK);
    }
}
