package com.project.service.product.impl;

import com.project.model.product.PriceStep;
import com.project.repository.product.IPriceStepRepository;
import com.project.service.product.IPriceStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceStepService implements IPriceStepService {
    @Autowired
    private IPriceStepRepository priceStepRepository;

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: find all Category of Product
     *
     * @return: List Category of Product
     */

    @Override
    public List<PriceStep> findAll() {
        return priceStepRepository.findAll();
    }

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: save Price Step of Product
     *
     * @return: Price Step of Product
     */

    @Override
    public PriceStep savePriceStep(PriceStep priceStep) {
        return priceStepRepository.save(priceStep);
    }

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: save Price Step of Product
     *
     * @return: Price Step of Product
     */

    @Override
    public PriceStep getPriceStep(Integer priceStep) {
        return priceStepRepository.findById(priceStep).orElse(null);
    }

    @Override
    public List<PriceStep> getListPriceStep() {
        return null;
    }

}
