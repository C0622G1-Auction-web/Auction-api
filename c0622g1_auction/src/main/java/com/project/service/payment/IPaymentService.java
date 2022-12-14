package com.project.service.payment;

import com.project.model.payment.Payment;

import java.util.List;

public interface IPaymentService {
    List<Payment> findValidPaymentByUserId(String userId);
    
    /**
     * Created by: ChauPTM
     * Date created: 13/12/2022
     * Function: to find payment by id
     *
     * @param id
     * @return Payment
     */
    Payment findPaymentById(Integer id);
}
