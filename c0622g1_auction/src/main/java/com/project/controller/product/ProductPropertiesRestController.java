package com.project.controller.product;

import com.project.model.product.AuctionStatus;
import com.project.model.product.SearchProductRange;
import com.project.service.product.IProductPropertiesService;
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
@RequestMapping("api/v1/product-properties")
public class ProductPropertiesRestController {

    @Autowired
    private IProductPropertiesService productPropertiesService;

    /**
     * Create by GiangLBH
     * Date created: 17/12/2022
     * Function: get all SearchProductRange
     *
     * @return HttpStatus.NO_CONTENT if not found any object
     * HttpStatus.OK and SearchProductRange list if found
     */
    @GetMapping("/price-range")
    public ResponseEntity<List<SearchProductRange>> getListSearchProductRange() {
        List<SearchProductRange> searchProductRangeList = productPropertiesService.getListSearchProductRange();
        if (searchProductRangeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(searchProductRangeList, HttpStatus.OK);
    }

    /**
     * Create by GiangLBH
     * Date created: 17/12/2022
     * Function: get all AuctionStatus
     *
     * @return HttpStatus.NO_CONTENT if not found any object
     * HttpStatus.OK and AuctionStatus list if found
     */
    @GetMapping("/auction-status")
    public ResponseEntity<List<AuctionStatus>> getListAuctionStatus() {
        List<AuctionStatus> auctionStatusList = productPropertiesService.getListAuctionStatus();
        if (auctionStatusList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(auctionStatusList, HttpStatus.OK);
    }
}
