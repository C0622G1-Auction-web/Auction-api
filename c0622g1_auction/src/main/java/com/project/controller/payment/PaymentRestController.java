package com.project.controller.payment;

import com.project.model.payment.Payment;
import com.project.service.payment.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/payments")
public class PaymentRestController {

    @Autowired
    private IPaymentService paymentService;

    /**
     * Created by: ChauPTM
     * Date created: 13/12/2022
     * Function: to find payment by id
     * @param id
     * @return HttpStatus.NO_CONTENT, HttpStatus.OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable Integer id) {
        Payment payment = paymentService.findPaymentById(id);
        if (payment == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

}
