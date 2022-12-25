package com.project.service.auction;

import com.project.dto.AuctionDto;
import com.project.dto.auction.ITransactionDto;
import com.project.dto.auction.TransactionSearchDto;
import com.project.dto.product.IAuctionProductDto;
import com.project.model.auction.Auction;
import com.project.model.product.Product;
import com.project.model.users.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;

public interface IAuctionService {


    /**
     * Created by : HuyNV,
     * Date created: 13/12/2022
     * Function: to list and search transaction
     *
     * @param pageable
     * @return
     */
    Page<ITransactionDto> findAllTransaction(TransactionSearchDto transactionSearchDto, Pageable pageable);

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
    List<ITransactionDto> findByListId(List<Integer> idList);

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
    AuctionDto addAuction(AuctionDto auctionDto);

    /**
     * Created by : HuyNV
     * Date Created: 20/12/2022
     * Function: to find transaction by List ids
     *
     * @param idList
     * @return
     */
    List<Integer> getAuctionIds(List<Integer> idList);

    /**
     * Created by: AnhTDQ,
     * Date created: 13/12/2022
     * Function: get page auction product by product id
     *
     * @param 'userId'
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */

    Page<IAuctionProductDto> getPageAuctionProductByUserId(Integer userId, Pageable pageable);

    Optional<Auction> getAuctionByProductId(Integer productId);

    /**
     * Created by: TienBM,
     * Date created: 25/12/2022
     * Function: Send Mail First Auction
     *
     * @param  maxCurrentPrice, userId, productId
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */
    void sendMailFirstAuction(Double maxCurrentPrice, Integer userId, Integer productId) throws MessagingException;

    /**
     * Created by: TienBM,
     * Date created: 25/12/2022
     * Function: Get Second Auction
     *
     * @param  productId
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */
    Optional<Auction> getSecondAuction(Integer productId);


    /**
     * Created by: TienBM,
     * Date created: 25/12/2022
     * Function: Send Mail Second Auction
     *
     * @param  user, product, currentPrice
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */
    void sendMailSecondAuction(User user, Product product, Double currentPrice, Double maxCurrentPrice) throws MessagingException;
}
