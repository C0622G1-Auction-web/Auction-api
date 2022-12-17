package com.project.service.product;

import com.project.model.product.PriceStep;
import com.project.model.product.Category;
import com.project.model.product.PriceStep;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IPriceStepService {
    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: find all Price Step
     */
    List<PriceStep> findAll();

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: Save Price Step of Product
     */

    PriceStep savePriceStep(PriceStep priceStep);

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * @Param: int ID of Price Step
     * Function: get Price Step of Product
     */

    PriceStep getPriceStep(Integer priceStep);

    List<PriceStep> getListPriceStep();

}
