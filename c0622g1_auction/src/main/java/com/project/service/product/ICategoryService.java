package com.project.service.product;

import com.project.model.product.Category;
import com.project.model.product.PriceStep;

import java.util.List;

public interface ICategoryService {
    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: list Category of Product
     */
    List<Category> findAll();

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: Save Category of Product
     */

    Category saveCategory(Category category);

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * @Param: int ID of Category
     * Function: get Category of Product
     */

    Category getCategory(Integer categoryInteger);

}
