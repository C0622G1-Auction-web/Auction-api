package com.project.service.product.impl;

import com.project.model.product.ImgUrlProduct;
import com.project.repository.product.IImgUrlProductRepository;
import com.project.service.product.IImgUrlProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgUrlProductService implements IImgUrlProductService {
    @Autowired
    private IImgUrlProductRepository imgUrlProductRepository;

    @Override
    public List<ImgUrlProduct> findImgByProductId(Integer id) {
        return imgUrlProductRepository.findImgByProductId(id);
    }

    @Override
    public void saveImgProduct(ImgUrlProduct imgUrlProduct) {
        imgUrlProductRepository.saveImgProduct(imgUrlProduct.getUrl(), imgUrlProduct.getProduct().getId());
    }
}
