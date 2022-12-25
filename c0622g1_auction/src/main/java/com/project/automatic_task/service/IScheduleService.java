package com.project.automatic_task.service;

import com.project.automatic_task.dto.IPaymentCheckDto;
import com.project.automatic_task.dto.IProductTimeDto;
import com.project.automatic_task.dto.ITopAuctionDetailDto;

import java.util.List;

public interface IScheduleService {
    List<IProductTimeDto> checkStartTime();

    void openAuction(Integer id);

    List<IProductTimeDto> checkEndTime();

    ITopAuctionDetailDto findSuccessAuction(Integer id);

    void setSuccessProduct(Integer id);

    void setFailureProduct(Integer id);

    void setSuccessAuction(Integer auctionId);

    void createPayment(Integer auctionId);

    List<IPaymentCheckDto> getPaymentOutOfEndDate();

    void setFailurePayment(Integer paymentId);

    void lockAccount(Integer buyerId);
}
