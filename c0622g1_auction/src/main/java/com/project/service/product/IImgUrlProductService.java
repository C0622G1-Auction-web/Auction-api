package com.project.service.product;

import com.project.model.product.ImgUrlProduct;
import com.project.dto.product.ImgUrlProductDTO;

import java.util.List;

public interface IImgUrlProductService {
    List<ImgUrlProduct> findImgByProductId(Integer id);

    void saveImgProduct(ImgUrlProduct imgUrlProduct);

}
