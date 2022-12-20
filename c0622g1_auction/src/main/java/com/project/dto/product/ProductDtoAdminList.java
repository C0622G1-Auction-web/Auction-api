package com.project.dto.product;

/**
 * Create by: GiangLBH
 * Date created: 18/12/2022
 * For: show to list product role admin
 */
public interface ProductDtoAdminList {
    Integer getId();

    Boolean getDeleteStatus();

    String getDescription();

    String getEndTime();

    Double getInitialPrice();

    String getName();

    String getRegisterDay();

    String getStartTime();

    String getAuctionStatus();

    String getCategory();

    Double getPriceStep();

    String getReviewStatus();

    Integer getReviewStatusId();

    String getUserName();

    String getUserEmail();

    Integer getUserId();
}