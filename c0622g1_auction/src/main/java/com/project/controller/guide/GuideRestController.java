package com.project.controller;

import com.project.model.guide.Guide;
import com.project.service.guide.IGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("auction/api/guide")
@CrossOrigin("*")
public class GuideRestController {
    @Autowired
    private IGuideService guideService;
    @GetMapping()
    public ResponseEntity<List<Guide>> getGuideList() {
        List<Guide> guideList = guideService.findAll();
        return new ResponseEntity<>(guideList, HttpStatus.OK);
    }
}
