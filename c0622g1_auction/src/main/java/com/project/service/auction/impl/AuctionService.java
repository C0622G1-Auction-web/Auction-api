package com.project.service.auction.impl;

import com.project.dto.product.IAuctionProductDto;
import com.project.model.product.Product;
import com.project.dto.AuctionDto;
import com.project.model.auction.Auction;
import com.project.repository.auction.IAuctionRepository;
import com.project.service.auction.IAuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService implements IAuctionService {
    @Autowired
    private IAuctionRepository auctionRepository;



    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: get page auction by product id
     *
     * @param productId
     * @param pageable
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */
    @Override
    public Page<Auction> getPageAuctionByProductId(Integer productId, Pageable pageable) {
        return auctionRepository.getPageAuctionByProductId(productId, pageable);
    }

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: find product by id
     *
     * @param auctionDto
     * @return HttpStatus.BAD_REQUEST if result is error or HttpStatus.OK if result is not error
     */
    @Override
    public void addAuction(AuctionDto auctionDto) {
        auctionRepository.addAuction(
                auctionDto.getCurrentPrice(),
                auctionDto.getProductId(),
                auctionDto.getUserId());
    }


    /**
     * Created by: AnhTDQ,
     * Date created: 13/12/2022
     * Function: get page auction product by product id
     *
     * @param 'userID'
     * @param pageable
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */

    @Override
    public Page<IAuctionProductDto> getPageAuctionProductByUserId(Integer userId, Pageable pageable) {
        return auctionRepository.getPageAuctionProductByIdUser(userId,pageable);
    }
}
