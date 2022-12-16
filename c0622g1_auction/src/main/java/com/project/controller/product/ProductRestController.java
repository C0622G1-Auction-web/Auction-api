package com.project.controller.product;

import com.project.dto.IProductDto;
import com.project.model.product.Product;
import com.project.model.product.ReviewStatus;
import com.project.service.product.IProductService;
import com.project.service.product.IReviewStatusService;
import com.project.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin("*")
public class ProductRestController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IReviewStatusService iReviewStatusService;

    /**
     * Create by AnhTDQ
     * Date created: 15/12/2022
     * Function: get all products Sign up for auctions
     *
     * @return HttpStatus.NO_CONTENT if not found any product /  HttpStatus.OK and Products page if found
     */

    @GetMapping("/list")
    public ResponseEntity<Page<IProductDto>> historyProduct(Integer id, Pageable pageable) {
        Page<IProductDto> productList = productService.showProductById(1, pageable);

        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);

    }

    /**
     * Create by AnhTDQ
     * Date created: 15/12/2022
     * Function: cancel products Sign up for auctions
     *
     * @return : HttpStatus.OK and cancel successfully
     */

    @GetMapping("/canceled/{id}")
    public ResponseEntity<Product> canceledProduct(@PathVariable("id") Integer id) {
        productService.cancelProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * Create by AnhTDQ
     * Date created: 15/12/2022
     * Function: get all reviewStatus of Sign up for auctions
     *
     * @return HttpStatus.NO_CONTENT if not found any reviewStatus /  HttpStatus.OK and  list reviewStatus if found
     */

    @GetMapping("/listReviewStatus")
    public ResponseEntity<List<ReviewStatus>> showReviewStatus() {
        List<ReviewStatus> reviewStatusList = iReviewStatusService.findAll();
        if (reviewStatusList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reviewStatusList,HttpStatus.OK);
    }

}
