package com.project.service.product;

import com.project.model.product.ImgUrlProduct;

import java.util.List;

public interface IImgUrlProductService {

    void saveImgProduct(ImgUrlProduct imgUrlProduct);

    ImgUrlProduct getImgUrlProduct(Integer id);


    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: find image of product by ID
     */

    List<ImgUrlProduct> findImgByProductId(Integer id);

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: find image by ID
     */

    ImgUrlProduct findById(int id);

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: save image of product
     */

    void update(ImgUrlProduct imgUrlProduct);

    void delete(ImgUrlProduct imgUrlProduct);
}
