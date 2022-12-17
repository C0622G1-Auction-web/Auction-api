package com.project.service.product.impl;

import com.project.model.product.ImgUrlProduct;
import com.project.model.product.dto.ImgUrlProductDTO;
import com.project.repository.product.IImgUrlProductRepository;
import com.project.service.product.IImgUrlProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgUrlProductService implements IImgUrlProductService {
    @Autowired
    private IImgUrlProductRepository imgUrlProductRepository;

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * @pathVariable: ID
     * Function: find image of product by ID
     * @return List<ImgUrlProduct>
     */

    @Override
    public List<ImgUrlProduct> findImgByProductId(Integer id) {
        return imgUrlProductRepository.findImgByProductId(id);
    }

    @Override
    public void saveImgProduct(ImgUrlProductDTO imgUrlProductDTO) {
        imgUrlProductRepository.saveImgProduct(imgUrlProductDTO.getUrl(), imgUrlProductDTO.getProductId());
    }


    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * @pathVariable: ID
     * Function: find image by ID
     * @return ImgUrlProduct
     */

    @Override
    public ImgUrlProduct findById(int id) {
        return imgUrlProductRepository.findImageById(id);
    }

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * @param: url, ID
     * Function: save Image of Product
     */

    @Override
    public void saveImgProduct(ImgUrlProduct imgUrlProduct) {
        imgUrlProductRepository.createImgProduct(imgUrlProduct.getUrl(), imgUrlProduct.getProduct().getId());
    }
}
