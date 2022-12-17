package com.project.service.product.impl;

import com.project.repository.product.ICategoryRepository;
import com.project.service.product.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
}
