package com.project.controller.guide;
import com.project.model.guide.Guide;
import com.project.service.guide.IGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auction/api/guide")
@CrossOrigin("*")
public class GuideRestController {
    @Autowired
    private IGuideService guideService;
    @GetMapping()
    public ResponseEntity<List<Guide>> getGuideList() {
        List<Guide> guideList = guideService.findAllGuide();
        if(guideList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(guideList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Guide> getGuideById(@PathVariable int id) {
        Guide editGuide = guideService.getGuideById(id);
        if(editGuide==null) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(editGuide, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> createGuide(@RequestBody Guide guide){
        guideService.createGuide(guide);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
