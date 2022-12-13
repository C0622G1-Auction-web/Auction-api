package com.project.service.payment.impl;

import com.project.dto.IPaymentDto;
import com.project.repository.payment.IPaymentRepository;
import com.project.service.payment.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    private IPaymentRepository paymentRepository;

    @Override
    public Page<IPaymentDto> showPayment(Pageable pageable) {
        return paymentRepository.showPayment(pageable);
    }
}
