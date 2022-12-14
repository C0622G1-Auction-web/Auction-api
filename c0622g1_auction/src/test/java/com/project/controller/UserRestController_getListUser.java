package com.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserRestController_getListUser {

    @Autowired
    private MockMvc mockMvc;


    /**
     * Created by: HaiNT
     * Date created: 14/12/2022
     * Function: to test method find all products when return result is empty
     */
    @Test
    public void getListUser_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/products"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HaiNT
     * Date created: 14/12/2022
     * Function: to test method find all products when return result have size > 0
     */
    @Test
    public void getListUser_6() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/products?page=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].firstName").value("Nguyễn"))
                .andExpect(jsonPath("content[0].lastName").value("Thanh Hải"))
                .andExpect(jsonPath("content[0].address.id").value(1))
                .andExpect(jsonPath("content[0].userType.id").value(1))
                .andExpect(jsonPath("content[0].account.id").value(1))
                .andExpect(jsonPath("content[2].firstName").value("Le"))
                .andExpect(jsonPath("content[2].lastName").value("Hữu Trường13"))
                .andExpect(jsonPath("content[2].address.id").value(3))
                .andExpect(jsonPath("content[2].userType.id").value(3))
                .andExpect(jsonPath("content[2].account.id").value(3));
    }


}
