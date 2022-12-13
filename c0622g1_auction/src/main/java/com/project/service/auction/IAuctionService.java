package com.project.service.auction;

import com.project.dto.IAuctionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAuctionService {

    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: get page auction by product id
     * @param productId
     * @param pageable
     * @return HttpStatus.OK if result is not empty
     * @return HttpStatus.NO_CONTENT if result is empty
     */

    Page<IAuctionDto>getPageAuctionByProductId(Integer productId, Pageable pageable);
}
