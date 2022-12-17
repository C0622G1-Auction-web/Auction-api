package com.project.service.product.impl;

import com.project.model.product.Category;
import com.project.repository.product.ICategoryRepository;
import com.project.service.product.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: find all Category of Product
     * @return: List Category of Product
     */

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: Save Category of Product
     */

    @Override
    public Category saveCategory(Category category) {
       return categoryRepository.save(category);
    }

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: save Category of Product
     * @return: Category of Product
     */

    @Override
    public Category getCategory(Integer categoryInteger) {
        return categoryRepository.findById(categoryInteger).orElse(null);
    }
}
