package com.project.service.payment.impl;

import com.project.dto.IPaymentDTO;
import com.project.model.payment.Payment;
import com.project.repository.payment.IPaymentRepository;
import com.project.service.payment.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    private IPaymentRepository paymentRepository;

    /**
     * Created by: ChauPTM
     * Date created: 13/12/2022
     * Function: to find payment by id
     *
     * @param id
     * @return HttpStatus.NO_CONTENT
     * @return HttpStatus.OK
     */
    @Override
    public Optional<IPaymentDTO> findByIdPayment(Integer id) {
        return paymentRepository.findByIdPayment(id);
    }
}
