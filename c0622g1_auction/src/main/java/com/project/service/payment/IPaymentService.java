package com.project.service.payment;

import com.project.dto.IPaymentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPaymentService {
    Page<IPaymentDto> showPayment (Pageable pageable);
}
