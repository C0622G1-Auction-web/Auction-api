package com.project.service.auction;

import com.project.dto.auction.TransactionSearchDto;
import com.project.model.auction.Auction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.project.dto.AuctionDto;
import com.project.model.auction.Auction;
import com.project.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAuctionService {

    /**
     * Created by : HuyNV,
     * Date created: 13/12/2022
     * Function: to list and search transaction
     *
     * @param pageable
     * @return
     */
    Page<Auction> findAllTransaction(TransactionSearchDto transactionSearchDto, Pageable pageable);

    /**
     * Created by : HuyNV
     * Date created: 14/12/2022
     * Function: to delete transaction by List ids
     *
     * @param idList
     */
    void removeByListId(List<Integer> idList);

    /**
     * Created by : HuyNV
     * Date Created: 14/12/2022
     * Function: to find transaction by List ids
     *
     * @param idList
     * @return
     */
    List<Auction> findByListId(List<Integer> idList);
    public List<Product> showProductAuctionById(int id);

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: get page auction by product id
     *
     * @param productId
     * @param pageable
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus. OK if result is not empty
     */
    Page<Auction> getPageAuctionByProductId(Integer productId, Pageable pageable);

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: Add Auction
     *
     * @param auctionDto
     * @return HttpStatus.BAD_REQUEST if result is error or HttpStatus. OK if result is not error
     */
    void addAuction(AuctionDto auctionDto);
}
