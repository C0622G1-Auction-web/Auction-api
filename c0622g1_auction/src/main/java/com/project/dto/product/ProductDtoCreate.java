package com.project.dto.product;

public class ProductDtoCreate {

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: create product dto to auction product
     */

    private int id;
    private String name;
    private String description;
    private Double initialPrice;
    private String startTime;
    private String endTime;
    private Boolean deleteStatus = false;
    private String registerDay;
    private Integer priceStep;
    private Integer reviewStatus;
    private Integer auctionStatus;
    private Integer category;
    private Integer user;

    public ProductDtoCreate() {
    }

    public ProductDtoCreate(int id, String name, String description, Double initialPrice, String startTime, String endTime, Boolean deleteStatus, String registerDay, Integer priceStep, Integer reviewStatus, Integer auctionStatus, Integer category, Integer user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.initialPrice = initialPrice;
        this.startTime = startTime;
        this.endTime = endTime;
        this.deleteStatus = deleteStatus;
        this.registerDay = registerDay;
        this.priceStep = priceStep;
        this.reviewStatus = reviewStatus;
        this.auctionStatus = auctionStatus;
        this.category = category;
        this.user = user;
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
