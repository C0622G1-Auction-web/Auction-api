package com.project.controller.payment;

import com.project.model.auction.Auction;
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
@RequestMapping("/api/v1/{id}/payment")
public class PaymentRestController {
    @Autowired
    IPaymentService paymentService;

    /**Created by UyenNC
     * Date created 13/12/2022
     * Function: Get unpaid payment list of user
     * @param userId
     * @return HttpStatus.NOT_FOUND
     * return HttpStatus.OK + List<Payment>
     */
    @GetMapping("list")
    public ResponseEntity<List<Payment>> getPaymentList(@PathVariable(value = "id") String userId) {
        List<Payment> paymentList = paymentService.findValidPaymentByUserId(userId);


        if (paymentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paymentList, HttpStatus.OK);
    }
}
