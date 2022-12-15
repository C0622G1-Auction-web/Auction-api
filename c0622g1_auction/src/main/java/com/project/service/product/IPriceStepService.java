package com.project.service.product;

import com.project.model.product.Category;
import com.project.model.product.PriceStep;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IPriceStepService {
    List<PriceStep> findAll();

}
