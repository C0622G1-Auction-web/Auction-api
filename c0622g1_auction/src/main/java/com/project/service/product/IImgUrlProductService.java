package com.project.service.product;

import com.project.model.product.ImgUrlProduct;
import com.project.model.product.dto.ImgUrlProductDTO;

import java.util.List;

public interface IImgUrlProductService {
    List<ImgUrlProduct> findImgByProductId(Integer id);

    void saveImgProduct(ImgUrlProductDTO imgUrlProductDTO);


}
