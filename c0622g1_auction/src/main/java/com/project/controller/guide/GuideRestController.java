package com.project.controller.guide;

import com.project.model.guide.Guide;
import com.project.service.guide.IGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.dto.guide.GuideDto;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1/guide")
@CrossOrigin("*")
public class GuideRestController {

    @Autowired
    private IGuideService guideService;

    /**
     * Create by: SonPT,
     * Date created: 13/12/2022
     * Function: find all guide
     *
     * @return list of guide status code OK
     */

    @GetMapping
    public ResponseEntity<List<Guide>> getAll(@RequestParam(required = false, defaultValue = "") String title) {
        List<Guide> guidePage = guideService.findAllGuide(title);
        if (guidePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Guide>>(guidePage, HttpStatus.OK);
    }

    /**
     * Create by: QuangND,
     * Date created: 13/12/2022
     * Function: find a guide by id
     *
     * @return an item guide
     * @Param: Id of guide want to get
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<Guide> getGuideById(@PathVariable int id) {

        Guide editGuide = guideService.getGuideById(id);
        if (editGuide == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(editGuide, HttpStatus.OK);
    }

    /**
     * Create by: QuangND,
     * Date created: 13/12/2022
     * Function: create a new guide
     *
     * @return a status code
     * @Param: an item Guide
     */
    @PostMapping()
    public ResponseEntity<Guide> createGuide(@Validated @RequestBody GuideDto guideDto,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Guide guideObj = new Guide();
        BeanUtils.copyProperties(guideDto, guideObj);
        guideService.createGuide(guideObj);
        return new ResponseEntity<>(guideObj, HttpStatus.CREATED);
    }

    /**
     * Create by: QuangND,
     * Date created: 13/12/2022
     * Function: update a guide
     *
     * @return a status code
     * @Param: id
     * @Param: an item Guide need to update
     */
    @PutMapping("")
    public ResponseEntity<GuideDto> updateGuide(@Validated @RequestBody GuideDto guideDto,
                                                BindingResult bindingResult) {
        if (guideService.getGuideById(guideDto.getId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        Guide guideObj = new Guide();
        BeanUtils.copyProperties(guideDto, guideObj);
        guideService.updateGuide(guideObj);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
