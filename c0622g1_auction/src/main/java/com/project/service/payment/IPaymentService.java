package com.project.service.payment;

import com.project.model.payment.Payment;

import java.util.List;

public interface IPaymentService {
    List<Payment> findValidPaymentByUserId(String userId);
}
