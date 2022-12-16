package com.project.repository.product;

import com.project.model.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: get all category status
     * @return category status list
     */
    @Query(value = "SELECT * FROM category", nativeQuery = true)
    List<Category> listCategory();

}
