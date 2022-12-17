
package com.project.controller.guide;

import com.project.dto.guide.ImgUrlGuideDto;
import com.project.model.guide.ImgUrlGuide;
import com.project.service.guide.IImgUrlGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auction/api/guide/image")
@CrossOrigin("*")
public class ImageGuideRestController {
    @Autowired
    private IImgUrlGuideService imgUrlGuideService;

    /**
     * Create by: QuangND,
     * Date created: 13/12/2022
     * Function: find all image url by id of guide
     *
     * @return list of image url and status code
     * @Param: id of guide
     */

    @GetMapping("/find/{id}")
    public ResponseEntity<List<ImgUrlGuide>> getImgGuideById(@PathVariable int id) {
        List<ImgUrlGuide> listImg = imgUrlGuideService.findImgByGuideId(id);
        if (listImg.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listImg, HttpStatus.OK);
    }

    /**
     * Create by: QuangND,
     * Date created: 13/12/2022
     * Function: create a new image url for a guide
     *
     * @return status code
     * @Param: a item of ImgUrlGuide
     */

    @PostMapping()
    public ResponseEntity<ImgUrlGuideDto> createImgGuide(@Validated @RequestBody ImgUrlGuideDto imgUrlGuideDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        imgUrlGuideService.createImgGuide(imgUrlGuideDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Create by: QuangND,
     * Date created: 13/12/2022
     * Function: update a image of guide
     *
     * @return status code
     * @Param: id of guide
     * @Param: a item of ImgUrlGuide
     */

    @PutMapping()
    public ResponseEntity<ImgUrlGuide> updateImgGuide(@Validated @RequestBody ImgUrlGuideDto imgUrlGuideDto,
                                                      BindingResult bindingResult) {
        if (imgUrlGuideService.findById(imgUrlGuideDto.getId()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        imgUrlGuideService.updateImgGuie(imgUrlGuideDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
