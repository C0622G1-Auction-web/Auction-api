package com.project.controller.payment;

import com.project.dto.IPaymentDto;
import com.project.model.payment.Payment;
import com.project.service.payment.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/payment")
public class PaymentRestController {
    @Autowired
    private IPaymentService iPaymentService;

    /**
     * Created by: BacBC,
     * Date created: 13/12/2022
     * Function: get currenPrice by id
     *
     * @param id
     * @return HttpStatus.BAD_REQUEST if result is error or HttpStatus.OK if result is not error
     */

    @GetMapping("/getCurrenPrice/{id}")
    public ResponseEntity<?> getCurrenPrice(@PathVariable("id") Integer id){
        IPaymentDto paymentDto = iPaymentService.getPrice(id);
        if(paymentDto==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(paymentDto,HttpStatus.OK);
    }



}
