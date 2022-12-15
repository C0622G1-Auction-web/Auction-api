package com.project.service.auction;

import com.project.model.product.Product;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAuctionService {
    List<Product> showProductAuctionById(@Param("id") int id);
}
