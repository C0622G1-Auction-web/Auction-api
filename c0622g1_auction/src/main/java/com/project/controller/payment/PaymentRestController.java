package com.project.controller.payment;

import com.project.dto.IPaymentDto;
import com.project.service.payment.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/payment")
public class PaymentRestController {
    @Autowired
    private IPaymentService iPaymentService;

    @GetMapping("/list")
    public ResponseEntity<?> showList(@PageableDefault( value = 10) Pageable pageable){
        Page<IPaymentDto> paymentList = iPaymentService.showPayment(pageable);
        if(paymentList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(paymentList,HttpStatus.OK);
    }

//    @GetMapping("/payment/{id}")
//    public ResponseEntity<?> getPayment(@PathVariable("id") Integer id){
//        IPaymentDto paymentDto = iPaymentService.findId(id);
//        if(paymentDto==null){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(paymentDto,HttpStatus.OK);
//    }
}
