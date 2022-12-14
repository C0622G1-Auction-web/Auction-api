package com.project.service.payment;

import com.project.dto.IPaymentDTO;
import com.project.model.payment.Payment;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IPaymentService {

    /**
     * Created by: ChauPTM
     * Date created: 13/12/2022
     * Function: to find payment by id
     *
     * @param id
     * @return HttpStatus.NO_CONTENT
     * @return HttpStatus.OK
     */
    Optional<IPaymentDTO> findByIdPayment(Integer id);
}
