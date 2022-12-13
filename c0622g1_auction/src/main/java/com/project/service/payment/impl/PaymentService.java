package com.project.service.payment.impl;

import com.project.model.payment.Payment;
import com.project.repository.payment.IPaymentRepository;
import com.project.service.payment.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    private IPaymentRepository paymentRepository;

    /**Created by UyenNC
     * Date created 13/12/2022
     * Function find valid payment by user id
     * @param userId
     * @return List<Payment>
     */
    @Override
    public List<Payment> findValidPaymentByUserId(String userId) {
        return paymentRepository.findValidPaymentByUserId(userId);
    }
}
