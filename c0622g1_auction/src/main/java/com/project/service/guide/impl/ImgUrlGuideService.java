package com.project.service.guide.impl;

import com.project.repository.guide.IImgUrlGuideRepository;
import com.project.service.guide.IImgUrlGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImgUrlGuideService implements IImgUrlGuideService {
    @Autowired
    private IImgUrlGuideRepository imgUrlGuideRepository;
}
