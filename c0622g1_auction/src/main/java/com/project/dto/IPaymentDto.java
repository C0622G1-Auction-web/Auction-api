package com.project.dto;

public interface IPaymentDto {
    String getEmail();
    String getPhone();
    String getFirstName();
    String getLastName();
    String getShippingDescription();
    Integer getId();
    Double getInitialPrice();
    String getProductName();
    String getDetailAddress();
    String getTown();
    String getDistrict();
    String getCity();
    String getCountry();
}
