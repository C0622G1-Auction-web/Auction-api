package com.project.service.product.impl;

import com.project.model.product.AuctionStatus;
import com.project.model.product.SearchProductRange;
import com.project.repository.product.IAuctionStatusRepository;
import com.project.repository.product.ISearchProductRangeRepository;
import com.project.service.product.IProductPropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPropertiesService implements IProductPropertiesService {

    @Autowired
    private IAuctionStatusRepository auctionStatusRepository;

    @Autowired
    private ISearchProductRangeRepository searchProductRangeRepository;

    /**
     * Create by: GiangLBH
     * Date created: 17/12/2022
     * Function: to find all searchProductRange list
     *
     * @return searchProductRange list
     */
    @Override
    public List<SearchProductRange> getListSearchProductRange() {
        return searchProductRangeRepository.getListSearchProductRanges();
    }

    /**
     * Create by: GiangLBH
     * Date created: 17/12/2022
     * Function: to find all AuctionStatus list
     *
     * @return AuctionStatus list
     */
    @Override
    public List<AuctionStatus> getListAuctionStatus() {
        return auctionStatusRepository.getListAuctionStatus();
    }
}
