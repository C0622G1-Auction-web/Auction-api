package com.project.service.auction;

import com.project.dto.IAuctionProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IAuctionService {
    Page<IAuctionProductDto> getPageAuctionProductByUserId(Integer userId, Pageable pageable);
}
