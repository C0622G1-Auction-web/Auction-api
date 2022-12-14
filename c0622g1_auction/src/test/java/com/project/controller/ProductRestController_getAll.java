package com.project.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductRestController_getAll {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method find all products when return result is empty
     */
    @Test
    public void getAll_5() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/products"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method find all products when return result have size > 0
     */
    @Test
    public void getAll_6() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/products?page=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(14))
                .andExpect(jsonPath("content[0].name").value("SH 150 Nhập 3 cục 2012 Sm 501 59D3-27627"))
                .andExpect(jsonPath("content[0].initialPrice").value(3000000.0))
                .andExpect(jsonPath("content[0].priceStep.id").value(3))
                .andExpect(jsonPath("content[4].name").value("Iphone 13 Pro Max"))
                .andExpect(jsonPath("content[4].initialPrice").value(2000000.0))
                .andExpect(jsonPath("content[4].priceStep.id").value(4));
    }
}