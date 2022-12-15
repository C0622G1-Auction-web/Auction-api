package com.project.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductRestController_findImgProductId {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void findImgProductId_id_1 () throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/products/img/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findImgProductId_id_2 () throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/products/img/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void findImgProductId_id_3 () throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/products/img/a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findImgProductId_id_4 () throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/products/img/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
