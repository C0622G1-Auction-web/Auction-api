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
public class ProductRestController_findById {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void findById_id_1 () throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/products/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findById_id_2 () throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/products/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void findById_id_3 () throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/products/a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findById_id_4 () throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/products/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}