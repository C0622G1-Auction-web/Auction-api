package com.project.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductRestController_findById {

    @Autowired
    MockMvc mockMvc;

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method find by id when id is null
     */
    @Test
    public void findById_id_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/products/find-by-id/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method find by id when id is empty
     */
    @Test
    public void findById_id_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/products/find-by-id/ "))
                .andDo(print())
                .andExpect(status().is5xxServerError());
    }

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method find by id when id not exists in database
     */
    @Test
    public void findById_id_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("api/v1/products/find-by-id/500"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method find by id when id exists in database
     */
    @Test
    public void findById_id_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("api/v1/products/find-by-id/2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("name").value("BÀN TRÀ APU BV4"))
                .andExpect(jsonPath("initialPrice").value(800000.0))
                .andExpect(jsonPath("priceStep.id").value(2));
    }
}
