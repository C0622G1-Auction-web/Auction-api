package com.project.service.guide.impl;

import com.project.model.guide.ImgUrlGuide;
import com.project.repository.guide.IImgUrlGuideRepository;
import com.project.service.guide.IImgUrlGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgUrlGuideService implements IImgUrlGuideService {
    @Autowired
    private IImgUrlGuideRepository imgUrlGuideRepository;

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     * Function: display list Image Guide
     * @param: ID
     * @return: List<ImgUrlGuide>
     */


    @Override
    public List<ImgUrlGuide> findImgByGuideId(Integer id) {
        return imgUrlGuideRepository.findImgByGuideId(id);
    }
}
