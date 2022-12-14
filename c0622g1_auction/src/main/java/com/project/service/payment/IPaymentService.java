package com.project.service.payment;

import com.project.model.payment.Payment;

public interface IPaymentService {

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
