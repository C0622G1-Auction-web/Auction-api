package com.project.service.product.impl;

import com.project.model.product.PriceStep;
import com.project.repository.product.IPriceStepRepository;
import com.project.repository.product.IProductRepository;
import com.project.service.product.IPriceStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceStepService implements IPriceStepService {
    @Autowired
    private IPriceStepRepository priceStepRepository;

    @Override
    public List<PriceStep> getListPriceStep() {
        return priceStepRepository.getPriceStep();
    }
}
