package com.project.controller.auction;

import com.project.dto.AuctionDto;
import com.project.dto.auction.ITransactionDto;
import com.project.dto.auction.TransactionSearchDto;
import com.project.dto.product.IAuctionProductDto;
import com.project.dto.product.ProductDto;
import com.project.model.auction.Auction;
import com.project.model.product.Product;
import com.project.service.auction.IAuctionService;
import com.project.service.product.IProductService;
import com.project.service.users.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
@RequestMapping("/api/v1/auction")
@CrossOrigin("*")
public class AuctionRestController {
    @Autowired
    private IAuctionService auctionService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IUserService userService;

    /**
     * Created by : HuyNV,
     * Date created: 13/12/2022
     * Function: to list and search transaction
     *
     * @return HttpStatus.OK
     */
    @PostMapping("/transaction")
    public ResponseEntity<Page<ITransactionDto>> getTransactionList(
            @RequestBody TransactionSearchDto transactionSearchDto,
            @PageableDefault(value = 5) Pageable pageable
    ) {
        if (transactionSearchDto.getCurrentPrice() == null) {
            transactionSearchDto.setCurrentPrice(0.0);
        }
        Page<ITransactionDto> transactionPage = auctionService.findAllTransaction(transactionSearchDto, pageable);
        if (transactionPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(transactionPage, HttpStatus.OK);
    }


    /**
     * Created by : HuyNV,
     * Date created: 18/12/2022
     * Function: to list delete transaction
     *
     * @param idList
     * @return HttpStatus.OK
     */
    @PostMapping("/find-by-list-id")
    public ResponseEntity<List<ITransactionDto>> findByListId(@RequestBody List<Integer> idList) {
        List<ITransactionDto> transactionList = auctionService.findByListId(idList);
        if (idList.size() != transactionList.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(transactionList, HttpStatus.OK);
    }


    /**
     * Created by : HuyNV,
     * Date created: 14/12/2022
     * Function: to delete transactions by idList
     *
     * @param idList
     * @return HttpStatus.NOT_FOUND if exists not found transaction
     */
    @PostMapping("/delete")
    public ResponseEntity<List<ITransactionDto>> remove(@RequestBody List<Integer> idList) {
        List<ITransactionDto> transactionList = auctionService.findByListId(idList);
        if (idList.size() != transactionList.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        auctionService.removeByListId(idList);
        return new ResponseEntity<>(transactionList, HttpStatus.OK);
    }

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: find product by id
     *
     * @param productId
     * @return HttpStatus.NOT_FOUND if result is not present or HttpStatus.OK if result is present
     */

    @GetMapping("auction-detail/{productId}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable(value = "productId") Integer productId) {
        Optional<Product> productOptional = productService.findProductById(productId);
        Double maxCurrentPrice = auctionService.getPageAuctionByProductId(productOptional.get().getId(), Pageable.unpaged()).getContent().get(0).getCurrentPrice();
        if (productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);
            productDto.setFullName(productDto.getUser().getFirstName() + " " + productDto.getUser().getLastName());
            productDto.setMaxCurrentPrice(maxCurrentPrice);
            return new ResponseEntity<>(productDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
    @GetMapping("/auction-product/{productId}")
    public ResponseEntity<Page<AuctionDto>> getPageAuctionByProductId(
            @PageableDefault(value = 3) Pageable pageable,
            @PathVariable(value = "productId") Integer productId) {
        Page<Auction> auctionPageByProductId = auctionService.getPageAuctionByProductId(productId, pageable);
        if (auctionPageByProductId.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Page<AuctionDto> auctionDtoPageByProductId = auctionPageByProductId.map(new Function<Auction, AuctionDto>() {
            @Override
            public AuctionDto apply(Auction auction) {
                AuctionDto auctionDto = new AuctionDto();
                auctionDto.setFullName(auction.getUser().getFirstName() + " " + auction.getUser().getLastName());
                auctionDto.setUserId(auction.getUser().getId());
                auctionDto.setProductId(auction.getProduct().getId());
                BeanUtils.copyProperties(auction, auctionDto);
                return auctionDto;
            }
        });
        return new ResponseEntity<>(auctionDtoPageByProductId, HttpStatus.OK);
    }

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: find product by id
     *
     * @param auctionDto
     * @return HttpStatus.BAD_REQUEST if result is error or HttpStatus.OK if result is not error
     */
    @PostMapping
    public ResponseEntity<?> addAuction(@Validated @RequestBody AuctionDto auctionDto,
                                        BindingResult bindingResult) {
        Double maxCurrentPrice = auctionService.getPageAuctionByProductId(auctionDto.getProductId(), Pageable.unpaged()).getContent().get(0).getCurrentPrice();
        auctionDto.setMaxCurrentPrice(maxCurrentPrice);
        new AuctionDto().validate(auctionDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        auctionService.addAuction(auctionDto);
        return new ResponseEntity(auctionDto, HttpStatus.OK);
    }

    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function: find auction product by id
     *
     * @param 'user Id'
     * @return HttpStatus.NOT_FOUND if result is not present or HttpStatus.OK if result is present
     */

    @GetMapping("/list/{id}")
    public ResponseEntity<Page<IAuctionProductDto>> historyAuctionProduct(Integer userId, Pageable pageable) {
        Page<IAuctionProductDto> productList = auctionService.getPageAuctionProductByUserId(1, pageable);

        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);

    }

}
