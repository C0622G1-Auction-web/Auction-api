package com.project.service.guide.impl;

import com.project.repository.guide.IGuideRepository;
import com.project.service.guide.IGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuideService implements IGuideService {
    @Autowired
    private IGuideRepository guideRepository;
}
