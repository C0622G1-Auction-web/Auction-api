package com.project.repository.product;

import com.project.model.product.ImgUrlProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IImgUrlProductRepository extends JpaRepository<ImgUrlProduct,Integer> {

    /**
     * Create by: HungNV,
     * Date created: 13/12/2022
     * Function: find img product by product id
     * @param id
     * @return list img product by product id
     */
    @Query(value="select * from img_url_product where img_url_product.product_id = :id",nativeQuery = true)
    List<ImgUrlProduct> findImgByProductId(@Param("id") Integer id);


    @Transactional
    @Modifying
    @Query(value="insert into img_url_product (url,product_id) values (?,?)",nativeQuery = true)
    ImgUrlProduct saveImgProduct(ImgUrlProduct imgUrlProduct
                                    @Param);
}
