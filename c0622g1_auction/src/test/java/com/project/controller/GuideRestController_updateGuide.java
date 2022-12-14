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
public class GuideRestController_updateGuide {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateGuide_title_19() throws Exception {
        GuideDto guideDto = new GuideDto();
        guideDto.setId(1);
        guideDto.setContent("Huong dan thanh toan");

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/auction/api/guide/1")
                .content(this.objectMapper.writeValueAsString(guideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateGuide_title_20() throws Exception {
        GuideDto guideDto = new GuideDto();
        guideDto.setId(1);
        guideDto.setTitle("");
        guideDto.setContent("Huong dan thanh toan");

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/auction/api/guide/1")
                .content(this.objectMapper.writeValueAsString(guideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateGuide_title_21() throws Exception {
        GuideDto guideDto = new GuideDto();
        guideDto.setId(1);
        guideDto.setTitle("#&* Huong dan cac buoc dang nhap");
        guideDto.setContent("Huong dan thanh toan hang");

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/auction/api/guide/1")
                .content(this.objectMapper.writeValueAsString(guideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateGuide_title_22() throws Exception {
        GuideDto guideDto = new GuideDto();
        guideDto.setId(1);
        guideDto.setTitle("HU");
        guideDto.setContent("Huong dan thanh toan hang");

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/auction/api/guide/1")
                .content(this.objectMapper.writeValueAsString(guideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateGuide_title_23() throws Exception {
        GuideDto guideDto = new GuideDto();
        guideDto.setId(1);
        guideDto.setTitle("HUuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu" +
                "uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        guideDto.setContent("Huong dan thanh toan hang");

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/auction/api/guide/1")
                .content(this.objectMapper.writeValueAsString(guideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateGuide_title_24() throws Exception {
        GuideDto guideDto = new GuideDto();
        guideDto.setId(1);
        guideDto.setTitle("Huong dan thanh toan");
        guideDto.setContent("Huong dan thanh toan hang gom cac buoc sau");

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/auction/api/guide/1")
                .content(this.objectMapper.writeValueAsString(guideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void updateGuide_content_19() throws Exception {
        GuideDto guideDto = new GuideDto();
        guideDto.setId(1);
        guideDto.setTitle("Huong dan dau gia");

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/auction/api/guide/1")
                .content(this.objectMapper.writeValueAsString(guideDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
