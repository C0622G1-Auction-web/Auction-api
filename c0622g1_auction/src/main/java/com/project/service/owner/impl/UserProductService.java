package com.project.service.owner.impl;

import com.project.repository.owner.IUserProductRepository;
import com.project.service.owner.IUserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProductService implements IUserProductService {
    @Autowired
    private IUserProductRepository userProductRepository;
}
