package com.project.controller.product;

import com.project.model.product.ImgUrlProduct;
import com.project.model.product.Product;
import com.project.service.product.ICategoryService;
import com.project.service.product.IImgUrlProductService;
import com.project.service.product.IPriceStepService;
import com.project.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
public class ProductRestController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IPriceStepService priceStepService;

    @Autowired
    private IImgUrlProductService iImgUrlProductService;



    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id){
        Optional<Product> product = productService.findById(id);
        if(!product.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    /**
     * Create by: HungNV,
     * Date created: 13/12/2022
     * Function: find img product by product id
     * @param id
     * @return HttpStatus.BAD_REQUEST
     * @return HttpStatus.NO_CONTENT
     * @return listImg and HttpStatus.HttpStatus.OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<List<ImgUrlProduct>> findImgProductId(@PathVariable Integer id){
        List<ImgUrlProduct> listImg = iImgUrlProductService.findImgByProductId(id);
        if(listImg.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listImg, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ImgUrlProduct> saveImgProduct(@RequestBody ImgUrlProduct imgUrlProduct){
        return new ResponseEntity<>(iImgUrlProductService.saveImgProduct(imgUrlProduct), HttpStatus.CREATED);
    }

}
