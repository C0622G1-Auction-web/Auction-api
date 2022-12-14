package com.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductRestController_findByListId {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method find list product by list id when list id is null
     */
    @Test
    public void findByListId_1() throws Exception {

        List<Integer> idList = null;

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/api/v1/products/find-by-list-id")
                        .content(this.objectMapper.writeValueAsString(idList))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method find list product by list id when list id is empty
     */
    @Test
    public void findByListId_2() throws Exception {

        List<Integer> idList = new ArrayList<>();

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/api/v1/products/find-by-list-id")
                        .content(this.objectMapper.writeValueAsString(idList))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method find list product by list id when has id not exists in database
     */
    @Test
    public void findByListId_3() throws Exception {

        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(1000);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/api/v1/products/find-by-list-id")
                        .content(this.objectMapper.writeValueAsString(idList))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method find list product when all id exist in database
     */
    @Test
    public void findByListId_4() throws Exception {

        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(7);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/api/v1/products/find-by-list-id")
                        .content(this.objectMapper.writeValueAsString(idList))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
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
