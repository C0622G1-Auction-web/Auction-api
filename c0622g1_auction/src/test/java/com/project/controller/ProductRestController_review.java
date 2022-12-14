package com.project.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductRestController_review {

    @Autowired
    MockMvc mockMvc;

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method review product by Product ID when id is null
     */
    @Test
    public void review_30() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/products/review/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method review product by Product ID when id is incorrect format (id = "a")
     */
    @Test
    public void review_31() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/products/review/a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method review product by Product ID when id is not exists in database (id = 555)
     */
    @Test
    public void review_32() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/products/review/555"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method review product by Product ID when  id is exists in database
     */
    @Test
    public void review_33() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/products/review/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
