package com.project.dto.product;

public interface IAuctionProductDto {

    /**
     * Created by: AnhTDQ,
     * Date created: 15/12/2022
     * Function: transfer data to backend
     */
    Integer getIdUser();
    String getNameProduct();
    String getDescription();
    String getPriceNow();
    String getRegisterDay();
    String getAuctionStatus();
}
