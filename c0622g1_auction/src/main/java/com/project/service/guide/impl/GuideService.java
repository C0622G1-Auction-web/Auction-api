package com.project.service.guide.impl;

import com.project.model.guide.Guide;
import com.project.repository.guide.IGuideRepository;
import com.project.service.guide.IGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideService implements IGuideService {
    @Autowired
    private IGuideRepository guideRepository;

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: display list guide
     * @return: List<Guide>
     */

    @Override
    public List<Guide> findAllGuide() {
        return guideRepository.findAllGuide();
    }
}
