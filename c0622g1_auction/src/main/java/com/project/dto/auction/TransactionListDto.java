package com.project.dto.auction;

public class TransactionListDto {

    private Integer id;
    private Double currentPrice;
    private String auctionTime;
    private Boolean auctionStatus;
    private Boolean deleteStatus;
    private String nameProduct;
    private String userPost;
    private String userBuying;

    public TransactionListDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(Boolean auctionStatus) {
        this.auctionStatus = auctionStatus;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getUserPost() {
        return userPost;
    }

    public void setUserPost(String userPost) {
        this.userPost = userPost;
    }

    public String getUserBuying() {
        return userBuying;
    }

    public void setUserBuying(String userBuying) {
        this.userBuying = userBuying;
    }
}
