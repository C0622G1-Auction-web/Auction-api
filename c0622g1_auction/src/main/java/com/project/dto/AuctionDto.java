package com.project.dto;

import javax.validation.constraints.NotNull;

public class AuctionDto {
    private Integer id;
    @NotNull
    private Double currentPrice;
    private String auctionDay;
    private Integer userId;
    private Integer productId;
//    private User user;
//    private Product product;
    private String fullName;

    public AuctionDto() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getAuctionDay() {
        return auctionDay;
    }

    public void setAuctionDay(String auctionDay) {
        this.auctionDay = auctionDay;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
