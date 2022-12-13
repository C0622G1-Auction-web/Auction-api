package com.project.controller.auction;

import com.project.dto.IAuctionDto;
import com.project.dto.ProductDto;
import com.project.model.product.Product;
import com.project.service.auction.IAuctionService;
import com.project.service.product.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/auction/api")
public class AuctionRestController {
    @Autowired
    private IAuctionService auctionService;

    @Autowired
    private IProductService productService;

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: find product by id
     * @param productId
     * @return HttpStatus.OK if result is present
     * @return HttpStatus.NOT_FOUND if result is not present
     */

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable(value = "productId") Integer productId) {
        Optional<Product> productOptional = productService.findProductById(productId);
        if (productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(),productDto);
            productDto.setFullName(productDto.getUser().getFirstName()+" "+productDto.getUser().getLastName());
            return new ResponseEntity<>(productDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: get page auction by product id
     * @param productId
     * @param pageable
     * @return HttpStatus.OK if result is not empty
     * @return HttpStatus.NO_CONTENT if result is empty
     */

    @GetMapping("/a-{productId}")
    public ResponseEntity<Page<IAuctionDto>> getPageAuctionByProductId(
            @PageableDefault(value = 3) Pageable pageable,
            @PathVariable(value = "productId") Integer productId) {
        Page<IAuctionDto> auctionPageByProductId = auctionService.getPageAuctionByProductId(productId, pageable);
        if (auctionPageByProductId.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(auctionPageByProductId, HttpStatus.OK);
    }
}
