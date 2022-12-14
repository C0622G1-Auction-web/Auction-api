package com.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dto.guide.GuideDto;
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
public class GuideRestController_createGuide {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: create guide with no item title
     * @return error status code
     */

    @Test
    public void createGuide_title_13() throws Exception {
        GuideDto guideDto = new GuideDto();
        guideDto.setContent("Huong dan thanh toan");

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/auction/api/guide")
                .content(this.objectMapper.writeValueAsString(guideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: create guide title empty
     * @return error status code
     */
    @Test
    public void createGuide_title_14() throws Exception {
        GuideDto guideDto = new GuideDto();
        guideDto.setTitle("");
        guideDto.setContent("Huong dan thanh toan");

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/auction/api/guide")
                .content(this.objectMapper.writeValueAsString(guideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: create guide with item title have special characters
     * @return error status code
     */
    @Test
    public void createGuide_title_15() throws Exception {
        GuideDto guideDto = new GuideDto();
        guideDto.setTitle("$#huong dan tu van");
        guideDto.setContent("Huong dan thanh toan");

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/auction/api/guide")
                .content(this.objectMapper.writeValueAsString(guideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: create guide with item title less than min length
     * @return error status code
     */
    @Test
    public void createGuide_title_16() throws Exception {
        GuideDto guideDto = new GuideDto();
        guideDto.setTitle("huo");
        guideDto.setContent("Huong dan thanh toan");

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/auction/api/guide")
                .content(this.objectMapper.writeValueAsString(guideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: create guide with item title length greater than max length
     * @return error status code
     */
    @Test
    public void createGuide_title_17() throws Exception {
        GuideDto guideDto = new GuideDto();
        guideDto.setTitle("huong dan huong dan huong dan huong dan huong dan" +
                "huong danhuong danhuong danhuong danhuong danhuong danhuong danhuong danhuong dan" +
                "huong dan");
        guideDto.setContent("Huong dan thanh toan");

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/auction/api/guide")
                .content(this.objectMapper.writeValueAsString(guideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: create guide with no item content
     * @return error status code
     */
    @Test
    public void createGuide_content_13() throws Exception {
        GuideDto guideDto = new GuideDto();
        guideDto.setTitle("huong dan cac buoc dang nhap");

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/auction/api/guide")
                .content(this.objectMapper.writeValueAsString(guideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: create guide with item content empty
     * @return error status code
     */
    @Test
    public void createGuide_content_14() throws Exception {
        GuideDto guideDto = new GuideDto();
        guideDto.setTitle("huong dan cac buoc dang nhap");
        guideDto.setContent("");

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/auction/api/guide")
                .content(this.objectMapper.writeValueAsString(guideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: create guide with item content have length less than min length
     * @return error status code
     */
    @Test
    public void createGuide_content_15() throws Exception {
        GuideDto guideDto = new GuideDto();
        guideDto.setTitle("huong dan cac buoc dang nhap");
        guideDto.setContent("nhu");

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/auction/api/guide")
                .content(this.objectMapper.writeValueAsString(guideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: create guide with all item valid
     * @return status code success
     */
    @Test
    public void createGuide_title_18() throws Exception {
        GuideDto guideDto = new GuideDto();
        guideDto.setTitle("huong dan cac buoc dang nhap");
        guideDto.setContent("Huong dan thanh toan");

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/auction/api/guide")
                .content(this.objectMapper.writeValueAsString(guideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
