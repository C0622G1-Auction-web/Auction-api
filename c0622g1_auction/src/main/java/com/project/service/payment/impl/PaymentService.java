package com.project.service.payment.impl;

import com.project.dto.payment.IPaymentAddressDto;
import com.project.dto.payment.IPaymentDto;
import com.project.dto.payment.IPaymentDtoCart;
import com.project.dto.payment.IPaymentTotalBillDto;
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
    public List<IPaymentDtoCart> findValidPaymentByUserId(String userId) {
        return paymentRepository.findValidPaymentByUserId(userId);
    }

    /**
     * Created by: ChauPTM
     * Date created: 13/12/2022
     * Function: to find payment by id using DTO
     *
     * @param idList
     * @return Payment
     */
    @Override
    public List<IPaymentDto> findByListId(List<Integer> idList) {
        return paymentRepository.findByListId(idList);
    }

    /**
     * Created by: ChauPTM
     * Date created: 13/12/2022
     * Function: to find payment by id using DTO
     *
     * @param idList,shippingDescription
     * @return Payment
     */
    @Override
    public void updateByListId(List<Integer> idList, String shippingDescription) {
        paymentRepository.updateByListId(idList, shippingDescription);
    }

    /**
     * Created by: ChauPTM
     * Date created: 22/12/2022
     * Function: to find payment by id using DTO
     *
     * @param idList,shippingDescription
     */
    @Override
    public void updatePaymentStatus(List<Integer> idList){
        paymentRepository.updatePaymentStatus(idList);
    }

}

