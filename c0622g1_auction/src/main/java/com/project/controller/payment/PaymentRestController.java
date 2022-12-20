package com.project.controller.payment;


import com.project.dto.IPaymentDTO;
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

    /**Created by UyenNC
     * Date created 13/12/2022
     * Function: Get unpaid payment list of user
     * @param userId
     * @return HttpStatus.NOT_FOUND
     * return HttpStatus.OK + List<Payment>
     */
    @GetMapping("{user_id}/list")
    public ResponseEntity<List<IPaymentDTO>> getPaymentList(@PathVariable(value = "user_id") String userId) {
        List<IPaymentDTO> paymentList = paymentService.findValidPaymentByUserId(userId);


        if (paymentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paymentList, HttpStatus.OK);
    }

    /**
     * Created by: ChauPTM
     * Date created: 13/12/2022
     * Function: to find payment by id
     * @param idList
     * @return HttpStatus.NO_CONTENT, HttpStatus.OK
     */
    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Payment>> getPayment(@RequestParam(value = "id") List<String> idList) {
        List<Payment> paymentList = new ArrayList<>();
        Payment payment;
        for (int i = 0; i < idList.size(); i++) {
            payment = paymentService.findPaymentById(Integer.valueOf(idList.get(i)));
            paymentList.add(payment);
        }


        if (paymentList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(paymentList, HttpStatus.OK);
    }
}
