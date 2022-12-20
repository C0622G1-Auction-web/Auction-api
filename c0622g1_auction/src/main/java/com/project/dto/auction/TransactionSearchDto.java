package com.project.dto.auction;

public class TransactionSearchDto {
    private String userPost;
    private String userBuying;
    private String nameProduct;
    private Double currentPrice;
    private String deleteStatus;
    private String paymentStatus;

    public TransactionSearchDto() {
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

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
