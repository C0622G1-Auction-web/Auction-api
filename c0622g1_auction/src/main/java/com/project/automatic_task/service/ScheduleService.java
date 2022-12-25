package com.project.automatic_task.service;

import com.project.automatic_task.dto.IPaymentCheckDto;
import com.project.automatic_task.dto.IProductTimeDto;
import com.project.automatic_task.dto.ITopAuctionDetailDto;
import com.project.automatic_task.repository.IScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService implements IScheduleService{

    @Autowired
    private IScheduleRepository scheduleRepository;

    @Override
    public List<IProductTimeDto> checkStartTime() {
        return scheduleRepository.checkStartTime();
    }

    @Override
    public void openAuction(Integer id) {
        scheduleRepository.openAuction(id);
    }

    @Override
    public List<IProductTimeDto> checkEndTime() {
        return scheduleRepository.checkEndTime();
    }

    @Override
    public ITopAuctionDetailDto findSuccessAuction(Integer id) {
        return scheduleRepository.findSuccessAuction(id);
    }

    @Override
    public void setSuccessProduct(Integer id) {
        scheduleRepository.setSuccessProduct(id);
    }

    @Override
    public void setFailureProduct(Integer id) {
        scheduleRepository.setFailureProduct(id);
    }

    @Override
    public void setSuccessAuction(Integer auctionId) {
        scheduleRepository.setSuccessAuction(auctionId);
    }

    @Override
    public void createPayment(Integer auctionId) {
        scheduleRepository.createPayment(auctionId);
    }

    @Override
    public List<IPaymentCheckDto> getPaymentOutOfEndDate() {
        return scheduleRepository.getPaymentOutOfEndDate();
    }

    @Override
    public void setFailurePayment(Integer paymentId) {
        scheduleRepository.setFailurePayment(paymentId);
    }

    @Override
    public void lockAccount(Integer buyerId) {
        scheduleRepository.lockAccount(buyerId);
    }
}
