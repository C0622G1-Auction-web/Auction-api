package com.project.service.product.impl;

import com.project.repository.product.IPriceStepRepository;
import com.project.repository.product.IProductRepository;
import com.project.service.product.IPriceStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceStepService implements IPriceStepService {
    @Autowired
    private IPriceStepRepository priceStepRepository;
}
