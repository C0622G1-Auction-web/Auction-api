package com.project.controller.product;

import com.project.dto.ProductDto;
import com.project.dto.ProductSearchDto;
import com.project.model.product.Product;
import com.project.service.product.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin("*")
public class ProductRestController {
    @Autowired
    private IProductService productService;

    /**
     * Created SangDD
     * Date created 13/12/2022
     * Function: search and filter product by name, rangePrice, categoryID productAuctionStatus
     * @param productSearchDto
     * @param pageable
     * @return HttpStatus.NOT_FOUND if result is empty
     * @return HttpStatus.OK if result is not empty
     */
    @GetMapping("/search")
    public ResponseEntity<Page<ProductDto>> getAllAndSearch(@RequestBody ProductSearchDto productSearchDto,
                                                            @PageableDefault(value = 5) Pageable pageable) {

        Page<Product> productPage = productService.getAllAndSearch(productSearchDto, pageable);
        if(productPage.hasContent()) {
            Page<ProductDto> productDtoPage  = productPage.map(new Function<Product, ProductDto>() {
                @Override
                public ProductDto apply(Product product) {
                    ProductDto productDto = new ProductDto();
                    BeanUtils.copyProperties(product, productDto);
                    return productDto;
                }
            });
            return new ResponseEntity<>(productDtoPage, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
