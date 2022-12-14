package com.project.service.payment;


import com.project.dto.IPaymentDto;
import com.project.model.payment.Payment;
import org.springframework.data.repository.query.Param;

public interface IPaymentService {
    IPaymentDto getPrice(Integer id);

    Payment update( String description, Integer id);
}
