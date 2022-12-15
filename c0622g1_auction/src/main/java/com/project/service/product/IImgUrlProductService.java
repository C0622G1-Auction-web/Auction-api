package com.project.service.product;

import com.project.dto.product.ImgUrlProductDTO;
import com.project.model.product.ImgUrlProduct;


import java.util.List;

public interface IImgUrlProductService {
    List<ImgUrlProduct> findImgByProductId(Integer id);

    void saveImgProduct(ImgUrlProductDTO imgUrlProductDTO);


}
