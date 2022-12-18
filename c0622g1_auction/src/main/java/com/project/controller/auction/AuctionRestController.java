package com.project.controller.auction;

import com.project.dto.auction.TransactionListDto;
import com.project.dto.auction.TransactionSearchDto;
import com.project.dto.product.ProductDto;
import com.project.model.auction.Auction;
import com.project.model.product.Product;
import com.project.service.auction.IAuctionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/auction")
public class AuctionRestController {
    @Autowired
    private IAuctionService auctionService;


    @GetMapping("/list")
    public ResponseEntity<Page<TransactionListDto>> getList(@PageableDefault(value = 5) Pageable pageable,
                                                            @RequestBody TransactionListDto transactionListDto){
        Page<TransactionListDto> list = auctionService.findAll(transactionListDto, pageable);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<TransactionListDto>>(list, HttpStatus.OK);

    }

    /**
     * Created by : HuyNV,
     * Date created: 13/12/2022
     * Function: to list and search transaction
     *
     * @return HttpStatus.NO_CONTENT
     * @return HttpStatus.OK
     */
    @GetMapping("/transaction")
    public ResponseEntity<Page<Auction>> getTransactionList(
            @RequestBody TransactionSearchDto transactionSearchDto,
            @PageableDefault(value = 5) Pageable pageable
    ){
        Page<Auction> transactionPage = auctionService.findAllTransaction(transactionSearchDto,pageable);
        if (transactionPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transactionPage, HttpStatus.OK);
    }

    /**
     * Created by : HuyNV,
     * Date created: 14/12/2022
     * Function: to delete transactions by idList
     *
     * @param idList
     * @return HttpStatus.OK and removed transaction if remove successfully
     * @return HttpStatus.NOT_FOUND if exists not found transaction
     */
    @PutMapping("/delete")
    public ResponseEntity<List<Auction>> remove(@RequestBody List<Integer> idList) {
        List<Auction> transactionList = auctionService.findByListId(idList);
        if (idList.size() != transactionList.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        auctionService.removeByListId(idList);
        return new ResponseEntity<>(transactionList, HttpStatus.OK);
    }
}
