package com.project.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductRestController_findByListId {

    @Autowired
    MockMvc mockMvc;

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method find by list id when list id is null
     */
    @Test
    public void findByListId_7() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/products/find-by-list-id/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method find by list id when list id is empty ([])
     */
    @Test
    public void findByListId_8() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/products/find-by-list-id/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method find by id when id not exists in database ([500, 501])
     */
    @Test
    public void findByListId_9() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/products/find-by-list-id/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method find by list id when list id exists in database [1, 7]
     */
    @Test
    public void findByListId_11() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/v1/products/find-by-list-id/"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].name").value("BÀN TRÀ APU BV4"))
                .andExpect(jsonPath("content[0].initialPrice").value(800000.0))
                .andExpect(jsonPath("content[0].priceStep.id").value(1))
                .andExpect(jsonPath("content[1].name").value("YAMAHA Nozza"))
                .andExpect(jsonPath("content[1].initialPrice").value(2000000.0))
                .andExpect(jsonPath("content[1].priceStep.id").value(4));

    }


}
