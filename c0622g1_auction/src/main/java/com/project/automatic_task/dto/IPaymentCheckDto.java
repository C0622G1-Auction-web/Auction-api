package com.project.automatic_task.dto;

public interface IPaymentCheckDto {
    Integer getPaymentId();
    Integer getBuyerId();
    Integer getSellerId();
    Integer getPrice();
    Integer getEndTime();
}
