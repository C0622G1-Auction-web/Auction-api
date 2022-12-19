package com.project.dto.product;

import com.project.dto.user.UserDto;
import com.project.model.auction.Auction;
import com.project.model.product.AuctionStatus;
import com.project.model.product.Category;
import com.project.model.product.ImgUrlProduct;
import com.project.model.product.PriceStep;
import com.project.model.users.User;
import java.util.Set;

public class ProductDto {
    private int id;
    private String fullName;
    private Double maxCurrentPrice;

    private String name;


    private String description;


    private Double initialPrice;


    private String startTime;


    private String endTime;


    private Boolean deleteStatus;


    private String registerDay;



    private PriceStep priceStep;


    private Category category;
    private User user;
    private ReviewStatus reviewStatus;
    private AuctionStatus auctionStatus;
    private Set<ImgUrlProduct> imgUrlProducts;
    private Set<Auction> auctions;

    public ProductDto() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Double getMaxCurrentPrice() {
        return maxCurrentPrice;
    }

    public void setMaxCurrentPrice(Double maxCurrentPrice) {
        this.maxCurrentPrice = maxCurrentPrice;
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

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getRegisterDay() {
        return registerDay;
    }

    public void setRegisterDay(String registerDay) {
        this.registerDay = registerDay;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ReviewStatus getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(ReviewStatus reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public AuctionStatus getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(AuctionStatus auctionStatus) {
        this.auctionStatus = auctionStatus;
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
}
