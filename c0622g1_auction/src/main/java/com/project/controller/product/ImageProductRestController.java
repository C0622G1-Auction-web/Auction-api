package com.project.controller.product;

import com.project.model.product.ImgUrlProduct;
import com.project.service.product.impl.ImgUrlProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auction/api/products/image")
@CrossOrigin("*")
public class ImageProductRestController {
    @Autowired
    private ImgUrlProductService imgUrlProductService;

    /**
     * Create by: SonPT,
     * Date created: 13/12/2022
     * Function: find all image url by id of product
     * @pathVariable: id of product
     * @return list of image url and status code
     */

    @GetMapping("/{id}")
    public ResponseEntity<List<ImgUrlProduct>> findImgProductById(@PathVariable int id) {
        List<ImgUrlProduct> listImg = imgUrlProductService.findImgByProductId(id);
        if (listImg.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listImg, HttpStatus.OK);
    }

    /**
     * Create by: SonPT,
     * Date created: 13/12/2022
     * Function: save a new image url for a product
     * @Param: a item of ImgUrlGuide
     * @return status code
     */

    @PostMapping()
    public ResponseEntity<ImgUrlProduct> createImgProduct(@RequestBody ImgUrlProduct imgUrlProduct) {
        imgUrlProductService.saveImgProduct(imgUrlProduct);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
