package com.project.repository.guide;

import com.project.model.guide.ImgUrlGuide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IImgUrlGuideRepository extends JpaRepository<ImgUrlGuide,Integer> {
    /**
     * Create by: SonPT,
     * Date created: 13/12/2022
     * Function: find all image url of guide in Database
     * @return list of image url
     */

    @Query(value = "SELECT * FROM img_url_guide WHERE guide_id=:id",nativeQuery=true)
    List<ImgUrlGuide> findImgByGuideId(@Param("id") int id);
}
