package com.project.repository.guide;

import com.project.model.guide.ImgUrlGuide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IImgUrlGuideRepository extends JpaRepository<ImgUrlGuide,Integer> {
}
