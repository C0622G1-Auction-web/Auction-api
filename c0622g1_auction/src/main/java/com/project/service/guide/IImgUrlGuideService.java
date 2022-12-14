package com.project.service.guide;

import com.project.model.guide.ImgUrlGuide;

import java.util.List;

public interface IImgUrlGuideService {
    List<ImgUrlGuide> findImgByGuideId(Integer id);
}
