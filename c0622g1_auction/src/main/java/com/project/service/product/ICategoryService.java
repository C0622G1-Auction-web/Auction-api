package com.project.service.product;

import com.project.model.product.Category;

import java.util.List;

public interface ICategoryService {
    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: list Category of Product
     */
    List<Category> findAll();
}
