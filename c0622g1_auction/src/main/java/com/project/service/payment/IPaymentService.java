package com.project.service.payment;

import com.project.dto.payment.IPaymentAddressDto;
import com.project.dto.payment.IPaymentTotalBillDto;
import com.project.model.payment.Payment;
import org.springframework.data.repository.query.Param;

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

//    List<Payment> findByListId(List<Integer> idList);

    List<IPaymentAddressDto> findByListId(List<Integer> idList);

    IPaymentTotalBillDto getTotalBill(List<Integer> idList);

    void updateByListId(List<Integer> idList, String shippingDescription);
}
