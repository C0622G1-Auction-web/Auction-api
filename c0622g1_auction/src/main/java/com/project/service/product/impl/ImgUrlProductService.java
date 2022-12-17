package com.project.service.product.impl;

import com.project.repository.product.IImgUrlProductRepository;
import com.project.service.product.IImgUrlProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImgUrlProductService implements IImgUrlProductService {
    @Autowired
    private IImgUrlProductRepository imgUrlProductRepository;
}
