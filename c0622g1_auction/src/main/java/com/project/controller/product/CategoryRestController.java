package com.project.controller.product;

import com.project.model.product.Category;
import com.project.service.product.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
@CrossOrigin("*")
public class CategoryRestController {
    @Autowired
    private ICategoryService categoryService;

    /**
     * Create by: SonPT,
     * Date created: 13/12/2022
     * Function: find all category of product
     *
     * @return list of image url and status code
     */

    @GetMapping()
    public ResponseEntity<List<Category>> getCategoryList() {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
}
