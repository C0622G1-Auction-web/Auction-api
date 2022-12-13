package com.project.service.product;

import com.project.model.product.Product;

public interface IProductService {
    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: get all product status
     * @return product status list
     */
    Product saveProduct(String description, String endTime, Double initialPrice, String name, String registerDay, String startTime, Integer categoryId, Integer priceStepId, Integer user_id);
}
