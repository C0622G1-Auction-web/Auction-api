package com.project.service.product;

import com.project.model.product.ImgUrlProduct;

import java.util.List;

public interface IImgUrlProductService {
    List<ImgUrlProduct> findImgByProductId(Integer id);

    ImgUrlProduct saveImgProduct(ImgUrlProduct imgUrlProduct);
}
