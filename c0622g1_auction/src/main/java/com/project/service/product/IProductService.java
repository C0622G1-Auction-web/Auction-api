package com.project.service.product;

import com.project.dto.ProductSearchDto;
import com.project.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    /**
     * Created SangDD
     * Date created 13/12/2022
     * Function: search and filter product by name, rangePrice, categoryID productAuctionStatus
     * @param productSearchDto
     * @param pageable
     * @return HttpStatus.NOT_FOUND if result is empty
     * @return HttpStatus.OK if result is not empty
     */
    Page<Product> getAllAndSearch(ProductSearchDto productSearchDto, Pageable pageable);

}
