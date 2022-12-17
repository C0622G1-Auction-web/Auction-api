package com.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dto.product.ImgUrlProductDTO;
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
public class ProductRestController_saveImgProduct {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * this function use to test the validation of field url more specific is null
     */
    @Test
    public void create_url_13() throws Exception {

        ImgUrlProductDTO imgUrlProductDTO = new ImgUrlProductDTO();
        imgUrlProductDTO.setProductId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/products/img/create")
                        .content(this.objectMapper.writeValueAsString(imgUrlProductDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * this function use to test the validation of field url more specific is blank
     */
    @Test
    public void create_url_14() throws Exception {

        ImgUrlProductDTO imgUrlProductDTO = new ImgUrlProductDTO();
        imgUrlProductDTO.setUrl("");
        imgUrlProductDTO.setProductId(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/products/img/create")
                        .content(this.objectMapper.writeValueAsString(imgUrlProductDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * this function use to test the validation of field productId more specific is null
     */
    @Test
    public void create_productId_13() throws Exception {

        ImgUrlProductDTO imgUrlProductDTO = new ImgUrlProductDTO();
        imgUrlProductDTO.setUrl("img");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/products/img/create")
                        .content(this.objectMapper.writeValueAsString(imgUrlProductDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
