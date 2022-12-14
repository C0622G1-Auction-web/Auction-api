package com.project.service.payment.impl;

import com.project.dto.IPaymentDto;
import com.project.model.payment.Payment;
import com.project.repository.payment.IPaymentRepository;
import com.project.service.payment.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    private IPaymentRepository paymentRepository;

    @Override
    public IPaymentDto getPrice(Integer id) {
        return paymentRepository.getPrice(id);
    }

    @Override
    public Payment update(String description, Integer id) {
        return paymentRepository.update(description,id);
    }
}
