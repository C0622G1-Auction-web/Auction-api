/**Create By QuangND
 Service: ImgUrlGuideService Service
 create Dat:16/12/2022
 **/
package com.project.service.guide.impl;
import com.project.dto.guide.ImgUrlGuideDto;
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

    @Override
    public List<ImgUrlGuide> findImgByGuideId(Integer id) {
        return imgUrlGuideRepository.findImgByGuideId(id);
    }

    @Override
    public void createImgGuide(ImgUrlGuideDto imgUrlGuideDto) {
        imgUrlGuideRepository.createImgGuide(imgUrlGuideDto.getUrl(),imgUrlGuideDto.getGuideId());
    }

    @Override
    public ImgUrlGuide findById(int id) {
        return imgUrlGuideRepository.findImageById(id);
    }

    @Override
    public void updateImgGuie(ImgUrlGuideDto imgUrlGuideDto) {
        imgUrlGuideRepository.updateImgGuie(imgUrlGuideDto.getId(),imgUrlGuideDto.getUrl());
    }
}
