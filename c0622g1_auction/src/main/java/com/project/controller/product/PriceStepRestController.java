package com.project.controller.product;

import com.project.model.product.PriceStep;
import com.project.service.product.IPriceStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pricestep")
@CrossOrigin("*")
public class PriceStepRestController {

    @Autowired
    private IPriceStepService priceStepService;

    /**
     * Create by: SonPT,
     * Date created: 13/12/2022
     * Function: find all price Step of product
     *
     * @return list of price Step and status code
     */

    @GetMapping()
    public ResponseEntity<List<PriceStep>> getPriceStepList() {
        List<PriceStep> priceStepList = priceStepService.findAll();
        if (priceStepList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(priceStepList, HttpStatus.OK);
    }
}
