package com.project.controller.auction;

import com.project.dto.IAuctionProductDto;
import com.project.service.auction.impl.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auction")
@CrossOrigin("*")
public class AuctionRestController {

    @Autowired
    private AuctionService auctionService;

    @GetMapping("/list")
    public ResponseEntity<Page<IAuctionProductDto>> historyAuctionProduct(Integer userId, Pageable pageable) {
        Page<IAuctionProductDto> productList = auctionService.getPageAuctionProductByUserId(1,pageable);

        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);

    }

}
