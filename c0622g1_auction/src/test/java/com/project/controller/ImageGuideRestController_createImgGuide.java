package com.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dto.guide.GuideDto;
import com.project.model.guide.Guide;
import com.project.model.guide.ImgUrlGuide;
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
public class ImageGuideRestController_createImgGuide {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void createGuide_url_18() throws Exception {
        ImgUrlGuide imgUrlGuide= new ImgUrlGuide();
        Guide guide = new Guide();
        imgUrlGuide.setUrl("kjgdgkkgd.png");

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/auction/api/guide/image")
                .content(this.objectMapper.writeValueAsString(imgUrlGuide))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
