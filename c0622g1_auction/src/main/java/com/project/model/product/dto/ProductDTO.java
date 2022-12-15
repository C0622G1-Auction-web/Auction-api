package com.project.model.product.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class ProductDTO{

    private int id;

    @NotBlank(message = "Không để trống")
    @NotNull(message = "Không để trống")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$[0-9]")
    @Size(min = 5, max =255)
    private String name;

    @NotBlank
    @NotNull
    @Size(min = 5, max = 255)
    private String description;


    @NotNull
    private Double initialPrice;

    @NotBlank
    private String startTime;

    @NotBlank
    private String endTime;

    private Boolean deleteStatus;
    private String registerDay;
    private Integer priceStep;
    private Integer reviewStatus;
    private Integer auctionStatus;
    private Integer category;

    @NotNull
    private Integer user;

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

    public Integer getPriceStep() {
        return priceStep;
    }

    public void setPriceStep(Integer priceStep) {
        this.priceStep = priceStep;
    }

    public Integer getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(Integer reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public Integer getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(Integer auctionStatus) {
        this.auctionStatus = auctionStatus;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }
}
