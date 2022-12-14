package com.project.service.guide;
import com.project.model.guide.Guide;

import java.util.List;

import com.project.model.guide.Guide;

import java.util.List;

public interface IGuideService {
    List<Guide> findAllGuide();



    Guide getGuideById(int id);

    void createGuide(Guide guide);

    void updateGuide(Guide guide);

}
