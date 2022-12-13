package com.project.service.auction.impl;

import com.project.dto.IAuctionDto;
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

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: get page auction by product id
     * @param productId
     * @param pageable
     * @return HttpStatus.OK if result is not empty
     * @return HttpStatus.NO_CONTENT if result is empty
     */

    @Override
    public Page<IAuctionDto> getPageAuctionByProductId(Integer productId, Pageable pageable) {
        return auctionRepository.getPageAuctionByProductId(productId,pageable);
    }
}
