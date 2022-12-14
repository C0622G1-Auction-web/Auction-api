package com.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserRestController_getListUserById {

    @Autowired
    MockMvc mockMvc;

    /**
     * Created by: HaiNT
     * Date created: 14/12/2022
     * Function: to test method find by id when id is null
     */
    @Test
    public void findById_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/user/1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HaiNT
     * Date created: 14/12/2022
     * Function: to test method find by id when id is empty
     */
    @Test
    public void findById_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/user/"))
                .andDo(print())
                .andExpect(status().is5xxServerError());
    }

    /**
     * Created by: HaiNT
     * Date created: 14/12/2022
     * Function: to test method find by id when id not exists in database
     */
    @Test
    public void findById_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/user/666"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: HaiNT
     * Date created: 14/12/2022
     * Function: to test method find by id when id exists in database
     */
    @Test
    public void findById_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/useraaaaa/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("firstName").value("Nguyễn"))
                .andExpect(jsonPath("lastName").value("Thanh Hải"))
                .andExpect(jsonPath("email").value("a@gmail.com"))
                .andExpect(jsonPath("phone").value("092452345126"))
                .andExpect(jsonPath("pointDedication").value(100.0))
                .andExpect(jsonPath("birthDay").value("1999-03-12"))
                .andExpect(jsonPath("idCard").value("1"))
                .andExpect(jsonPath("address.id").value(1))
                .andExpect(jsonPath("userType.id").value(1))
                .andExpect(jsonPath("account.id").value(1));
    }
}

