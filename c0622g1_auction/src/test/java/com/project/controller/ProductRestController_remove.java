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

public class ProductRestController_remove {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Created by : HuyNV,
     * Date created: 14/12/2022
     * Function: update = [item] = null
     *
     * @throws Exception
     */
    @Test
    public void remove_19() throws Exception {

        List<Integer> idList = null;

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/api/v1/products/remove")
                        .content(this.objectMapper.writeValueAsString(idList))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by : HuyNV,
     * Date created: 14/12/2022
     * Function: update = [item] = not found
     *
     * @throws Exception
     */
    @Test
    public void remove_22() throws Exception {

        List<Integer> idList = new ArrayList<>();
        idList.add(0);
        idList.add(1);
        idList.add(2);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/api/v1/products/remove")
                        .content(this.objectMapper.writeValueAsString(idList))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by : HuyNV,
     * Date created: 14/12/2022
     * Function: update Successful
     *
     * @throws Exception
     */
    @Test
    public void remove_24() throws Exception {

        List<Integer> idList = new ArrayList<>();

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put("api/v1/products/remove")
                        .content(this.objectMapper.writeValueAsString(idList))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
