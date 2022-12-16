package com.project.repository.guide;

import com.project.model.guide.ImgUrlGuide;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


import java.util.List;

@Repository
@Transactional
public interface IImgUrlGuideRepository extends JpaRepository<ImgUrlGuide,Integer> {
    /**

     * Create by: SonPT,
     * Date created: 13/12/2022
     * Function: find all image url of guide in Database
     * Create by: QuangND,
     * Date created: 13/12/2022
     * Function: find all image url of guide in DB
     * @return list of image url
     */

    @Query(value = "SELECT * FROM img_url_guide WHERE guide_id=:id",nativeQuery=true)
    List<ImgUrlGuide> findImgByGuideId(@Param("id") int id);


    /**
     * Create by: QuangND,
     * Date created: 13/12/2022
     * Function: create a new image url of guide in DB
     */


    @Modifying
    @Query(value="INSERT INTO img_url_guide (url,guide_id) VALUES (:url, :guide_id)",nativeQuery = true)
    void createImgGuide(@Param("url") String url,
                        @Param("guide_id") int id);

    /**
     * Create by: QuangND,
     * Date created: 13/12/2022
     * Function: find a image url of guide by id in DB
     * @return a image url
     */

    @Query(value="SELECT img.* FROM img_url_guide img where img.id=:id ", nativeQuery = true)
    ImgUrlGuide findImageById(int id);

    /**
     * Create by: QuangND,
     * Date created: 13/12/2022
     * Function: update a image url of guide by id in DB
     */

    @Modifying
    @Query(value = "UPDATE img_url_guide SET url=:url WHERE id=:id", nativeQuery = true)
    void updateImgGuie(@Param("id") int id,
                       @Param("url") String url);

}
