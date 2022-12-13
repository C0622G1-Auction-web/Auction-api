package com.project.service.auction;

import com.project.model.auction.Auction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAuctionService {
    Page<Auction> findAllTransaction(Pageable pageable);

    void removeByListId(List<Integer> idList);

    List<Auction> findByListId(List<Integer> idList);
}
