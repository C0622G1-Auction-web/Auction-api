package com.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class ImageGuideRestController_createImgGuide {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: create a new url of image of guide with url null (belong fuction in frontend)
     *
     * @return error status code
     */
    @Test
    public void createGuide_url_13() throws Exception {
        ImgUrlGuideDto imgUrlGuideDto = new ImgUrlGuideDto();
        imgUrlGuideDto.setGuideId(2);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/auction/api/guide/image")
                .content(this.objectMapper.writeValueAsString(imgUrlGuideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: create a new url of image of guide with guide_id null (belong fuction in frontend)
     *
     * @return error status code
     */
    @Test
    public void createGuide_guide_13() throws Exception {
        ImgUrlGuideDto imgUrlGuideDto = new ImgUrlGuideDto();
        imgUrlGuideDto.setUrl("hinhanhtest.jpg");
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/auction/api/guide/image")
                .content(this.objectMapper.writeValueAsString(imgUrlGuideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: create a new url of image of guide with url is empty (belong fuction in frontend)
     *
     * @return error status code
     */
    @Test
    public void createGuide_url_14() throws Exception {
        ImgUrlGuideDto imgUrlGuideDto = new ImgUrlGuideDto();
        imgUrlGuideDto.setUrl("");
        imgUrlGuideDto.setGuideId(2);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/auction/api/guide/image")
                .content(this.objectMapper.writeValueAsString(imgUrlGuideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: create a new url of image of guide with valid item
     *
     * @return status code success OK
     */
    @Test
    public void createGuide_url_18() throws Exception {
        ImgUrlGuideDto imgUrlGuideDto = new ImgUrlGuideDto();
        imgUrlGuideDto.setUrl("testanhdep");
        imgUrlGuideDto.setGuideId(2);
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/auction/api/guide/image")
                .content(this.objectMapper.writeValueAsString(imgUrlGuideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
