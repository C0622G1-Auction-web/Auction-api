package com.project.controller.payment;

import com.project.dto.IPaymentDTO;
import com.project.service.payment.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("api/payment/v1")
public class PaymentRestController {

    @Autowired
    private IPaymentService paymentService;

    /**
     * Created by: ChauPTM
     * Date created: 13/12/2022
     * Function: to find payment by id
     *
     * @param id
     * @return HttpStatus.NO_CONTENT
     * @return HttpStatus.OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<IPaymentDTO> getPayment(@PathVariable Integer id) {
        Optional<IPaymentDTO> paymentDTO = paymentService.findByIdPayment(id);
        if (!paymentDTO.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(paymentDTO.get(), HttpStatus.OK);
    }

}
