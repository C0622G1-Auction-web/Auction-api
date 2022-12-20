package com.project.dto;

import com.project.model.users.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;

public class AuctionDto implements Validator {

    private Integer id;
    @NotNull(message = "Current price can not be null")
    private Double currentPrice;
    private String auctionTime;
    private Integer userId;
    private Integer productId;
    private Double maxCurrentPrice;
    private User user;
    private String fullName;


    private Boolean deleteStatus = true;

    public AuctionDto() {
    }

    public Double getMaxCurrentPrice() {
        return maxCurrentPrice;
    }

    public void setMaxCurrentPrice(Double maxCurrentPrice) {
        this.maxCurrentPrice = maxCurrentPrice;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(String auctionTime) {
        this.auctionTime = auctionTime;
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


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AuctionDto auctionDto = (AuctionDto) target;
        if (auctionDto.getCurrentPrice() <= 0) {
            errors.rejectValue("currentPrice", "", "Current price must be positive");
        }
        if (auctionDto.getCurrentPrice() <= auctionDto.getMaxCurrentPrice()) {
            errors.rejectValue("currentPrice", "", "Bid cannot be less than current price");
        }


    }
}
