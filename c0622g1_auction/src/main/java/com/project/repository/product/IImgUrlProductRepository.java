package com.project.repository.product;

import com.project.model.product.ImgUrlProduct;
import com.project.model.product.ReviewStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IImgUrlProductRepository extends JpaRepository<ImgUrlProduct, Integer> {

}
