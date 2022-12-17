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

    @Override
    public List<Category> getListCategory() {
        return categoryRepository.listCategory();
    }

    @Override
    public Category getCategory(Integer category) {
        return categoryRepository.findById(category).orElse(null);
    }
}
