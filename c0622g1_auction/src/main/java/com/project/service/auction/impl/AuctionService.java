package com.project.service.auction.impl;

import com.project.dto.auction.ITransactionDto;
import com.project.dto.auction.TransactionListDto;
import com.project.dto.auction.TransactionSearchDto;
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
     * Created by : HuyNV,
     * Date created: 13/12/2022
     * Function: to list and search transaction
     *
     * @return HttpStatus.OK
     */

    @Override
    public Page<ITransactionDto> findAllTransaction(TransactionSearchDto transactionSearchDto, Pageable pageable) {
        return auctionRepository.findAllTransaction(transactionSearchDto, pageable);
    }

    /**
     * Created by : HuyNV
     * Date created: 14/12/2022
     * Function: to delete transaction by List ids
     *
     * @param idList
     */
    @Override
    public void removeByListId(List<Integer> idList) {
        auctionRepository.removeByListId(idList);
    }


    /**
     * Created by : HuyNV
     * Date Created: 14/12/2022
     * Function: to find transaction by List ids
     *
     * @param idList
     * @return
     */
    @Override
    public List<ITransactionDto> findByListId(List<Integer> idList) {
        return auctionRepository.findByListId(idList);
    }

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
        return auctionRepository.getPageAuctionProductByIdUser(userId, pageable);
    }
}
