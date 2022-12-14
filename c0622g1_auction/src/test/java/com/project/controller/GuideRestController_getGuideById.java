package com.project.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GuideRestController_getGuideById {
    @Autowired
    private MockMvc mockMvc;
    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: get a guide with item id == null
     * @return error status code
     */
    @Test
    public void getGuideById_id_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/auction/api/guide/find/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: get a guide with item id empty
     * @return error status code
     */

    @Test
    public void getGuideById_id_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/auction/api/guide/find/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: get a guide with item id not have in database
     * @return error status code
     */

    @Test
    public void getGuideById_id_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/auction/api/guide/find/20"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: get a guide with item id valid (exists in dabatabase)
     * @return a guide with valid infor
     */

    @Test
    public void getGuideById_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/auction/api/guide/find/2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(2))
                .andExpect(jsonPath("title").value("Cach tinh tien"))
                .andExpect(jsonPath("content").value("Tinh tien bang paypal"));
    }
}

