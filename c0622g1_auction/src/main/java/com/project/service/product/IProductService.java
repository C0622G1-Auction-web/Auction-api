package com.project.service.product;

import com.project.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {

    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function: get page products Sign up for auctions by user id
     * @param user id
     * @param pageable
     * @return HttpStatus.NO_CONTENT if result is empty or HttpStatus.OK if result is not empty
     */
    Page<ProductDto> showProductById(Integer id, Pageable pageable);

    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function:cancel Sign up for auctions by user id
     * @param user id
     * @return voi
     */
    void cancelProduct(Integer id);
}
