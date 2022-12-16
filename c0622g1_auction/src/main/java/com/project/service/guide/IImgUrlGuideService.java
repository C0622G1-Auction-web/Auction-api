package com.project.service.guide;

import com.project.dto.guide.ImgUrlGuideDto;
import com.project.model.guide.ImgUrlGuide;

import java.util.List;

public interface IImgUrlGuideService {
    List<ImgUrlGuide> findImgByGuideId(Integer id);
    void createImgGuide(ImgUrlGuideDto imgUrlGuideDto);
    ImgUrlGuide findById(int id);
    void updateImgGuie(ImgUrlGuideDto imgUrlGuideDto);
}
