package com.project.controller.payment;


import com.project.dto.payment.IPaymentAddressDto;
import com.project.dto.payment.IPaymentDto;
import com.project.dto.payment.IPaymentDtoCart;
import com.project.dto.payment.PaymentDtoGetShip;
import com.project.model.payment.Payment;
import com.project.service.payment.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/payments")
public class PaymentRestController {
    @Autowired
    IPaymentService paymentService;


    /**
     * Created by UyenNC
     * Date created 13/12/2022
     * Function: Get unpaid payment list of user
     *
     * @param userId
     * @return HttpStatus.NOT_FOUND
     * return HttpStatus.OK + List<Payment>
     */
    @GetMapping("{user_id}/list")
    public ResponseEntity<List<IPaymentDtoCart>> getPaymentList(@PathVariable(value = "user_id") String userId) {
        List<IPaymentDtoCart> paymentList = paymentService.findValidPaymentByUserId(userId);
        System.out.println(paymentList);

        if (paymentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(paymentList, HttpStatus.OK);
    }

    /**
     * Create by: ChauPTM
     * Date created: 14/12/2022
     * Function: to find payment by list id payment
     *
     * @return HttpStatus.BAD_REQUEST if exists any payment not found/  HttpStatus.OK and payments found
     */
    @PostMapping("/find-by-list-id")
    public ResponseEntity<List<IPaymentDto>> findByListId(@RequestBody List<Integer> idList) {
        if (idList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<IPaymentDto> paymentList = paymentService.findByListId(idList);

        if (idList.size() != paymentList.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(paymentList, HttpStatus.OK);
    }

    /**
     * Create by: ChauPTM
     * Date created: 14/12/2022
     * Function: to update payment (add shipping description) by list id
     *
     * @param paymentDtoGetShips
     * @return  HttpStatus.OK
     */
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody List<PaymentDtoGetShip> paymentDtoGetShips) {

        List<Integer> idList = new ArrayList<>();
        for (PaymentDtoGetShip payment : paymentDtoGetShips) {
            idList.add(payment.getId());
        }
        String shippingDescription = paymentDtoGetShips.get(0).getShippingDescription();
        paymentService.updateByListId(idList, shippingDescription);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

