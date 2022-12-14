package com.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dto.guide.GuideDto;
import com.project.dto.guide.ImgUrlGuideDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ImageGuideRestController_updateImgGuide {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: update url image of guide with id image Url is not exists in database
     *
     * @return error status code NOT FOUND
     */

    @Test
    public void updateImgGuide_ImgUrlGuideDto() throws Exception {
        ImgUrlGuideDto imgUrlGuideDto = new ImgUrlGuideDto();
        imgUrlGuideDto.setId(100);
        imgUrlGuideDto.setUrl("testanh.png");
        imgUrlGuideDto.setGuideId(2);
        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/auction/api/guide/image")
                .content(this.objectMapper.writeValueAsString(imgUrlGuideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: update url image of guide with item url null
     *
     * @return error status code NOT ACCEPTABLE
     */

    @Test
    public void updateImgGuide_url_13() throws Exception {
        ImgUrlGuideDto imgUrlGuideDto = new ImgUrlGuideDto();
        imgUrlGuideDto.setId(100);
        imgUrlGuideDto.setGuideId(2);
        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/auction/api/guide/image")
                .content(this.objectMapper.writeValueAsString(imgUrlGuideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: update url image of guide with item guideId null
     *
     * @return error status code NOT ACCEPTABLE
     */

    @Test
    public void updateImgGuide_guideId_13() throws Exception {
        ImgUrlGuideDto imgUrlGuideDto = new ImgUrlGuideDto();
        imgUrlGuideDto.setId(100);
        imgUrlGuideDto.setGuideId(2);
        imgUrlGuideDto.setUrl("testanh.jpg");
        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/auction/api/guide/image")
                .content(this.objectMapper.writeValueAsString(imgUrlGuideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: QuangND
     * Date created: 14/12/2022
     * Function: update url image of guide with all item valid
     *
     * @return status code OK
     */

    @Test
    public void updateImgGuide_guideId_24() throws Exception {
        ImgUrlGuideDto imgUrlGuideDto = new ImgUrlGuideDto();
        imgUrlGuideDto.setId(3);
        imgUrlGuideDto.setUrl("testanh.jpg");
        imgUrlGuideDto.setGuideId(2);
        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/auction/api/guide/image")
                .content(this.objectMapper.writeValueAsString(imgUrlGuideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
