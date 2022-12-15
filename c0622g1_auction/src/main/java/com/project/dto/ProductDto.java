package com.project.dto;
public interface ProductDto {

    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function: transfer data to backend
     */

    String getNameProduct();
    String getDescription();
    String getRegisterDay();
    String getReview();
    String getIsDelete();


import com.project.model.auction.Auction;
import com.project.model.product.*;
import com.project.model.users.User;

import java.util.Set;

public class ProductDto {
    private String name;
    private String description;
    private Double initialPrice;
    private String startTime;
    private String endTime;
    private PriceStep priceStep;
    private Category category;
    private Set<ImgUrlProduct> imgUrlProducts;
    private Set<Auction> auctions;
    private User user;
    private String fullName;


    public ProductDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(Double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() { return endTime; }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public PriceStep getPriceStep() {
        return priceStep;
    }

    public void setPriceStep(PriceStep priceStep) {
        this.priceStep = priceStep;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<ImgUrlProduct> getImgUrlProducts() {
        return imgUrlProducts;
    }

    public void setImgUrlProducts(Set<ImgUrlProduct> imgUrlProducts) {
        this.imgUrlProducts = imgUrlProducts;
    }

    public Set<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(Set<Auction> auctions) {
        this.auctions = auctions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFullName() { return fullName; }

    public void setFullName(String fullName) { this.fullName = fullName; }
}
