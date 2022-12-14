package com.project.model.product.dto;

import com.project.model.auction.Auction;
import com.project.model.product.*;
import com.project.model.users.User;
import com.project.model.users.dto.UserDTO;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.Set;

public class ProductDTO{

    private int id;

    @NotBlank
    @NotNull
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")
    @Size(min = 5, max =255)
    private String name;

    @NotBlank
    @NotNull
    @Size(min = 5, max = 255)
    private String description;

    @NotBlank
    @NotNull
    @Pattern(regexp = "^[0-9]+$")
    private Double initialPrice;

    @NotBlank
    private String startTime;

    @NotBlank
    private String endTime;

    private Boolean deleteStatus;
    private String registerDay;
    private PriceStepDTO priceStep;
    private ReviewStatusDTO reviewStatus;
    private AuctionStatusDTO auctionStatus;
    private CategoryDTO category;
    private Set<ImgUrlProduct> imgUrlProducts;
    private Set<Auction> auctions;
    private UserDTO user;

    public ProductDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public PriceStepDTO getPriceStep() {
        return priceStep;
    }

    public void setPriceStep(PriceStepDTO priceStep) {
        this.priceStep = priceStep;
    }

    public ReviewStatusDTO getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(ReviewStatusDTO reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public AuctionStatusDTO getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(AuctionStatusDTO auctionStatus) {
        this.auctionStatus = auctionStatus;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
