package com.project.service.payment;
import com.project.dto.payment.IPaymentAddressDto;
import com.project.dto.payment.IPaymentDto;
import com.project.dto.payment.IPaymentDtoCart;
import com.project.dto.payment.IPaymentTotalBillDto;
import com.project.model.payment.Payment;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPaymentService {
    List<IPaymentDtoCart> findValidPaymentByUserId(String userId);

    /**
     * Created by: ChauPTM
     * Date created: 21/12/2022
     * Function: to find payment by id
     *
     * @param idList
     * @return Payment
     */
    List<IPaymentDto> findByListId(List<Integer> idList);

    /**
     * Created by: ChauPTM
     * Date created: 21/12/2022
     * Function: to update shipping description by id
     *
     * @param idList
     * @return Payment
     */
    void updateByListId(List<Integer> idList, String shippingDescription);

    /**
     * Created by: ChauPTM
     * Date created: 22/12/2022
     * Function: to update payment status
     * @param idList
     */
    void updatePaymentStatus(List<Integer> idList);
}
