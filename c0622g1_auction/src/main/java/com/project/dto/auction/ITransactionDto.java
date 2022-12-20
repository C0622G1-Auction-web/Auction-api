package com.project.dto.auction;

public interface ITransactionDto {
    String getPaymentId();

    String getAuctionId();

    String getUserPost();

    String getUserBuying();

    String getAuctionDay();

    String getProductName();

    String getCurrentPrice();

    String getAuctionStatus();

    Boolean getDeleteStatus();

    Integer getPaymentStatus();

}
