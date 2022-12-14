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
public class ImageGuideRestController_getImgGuideById {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: get list of images of guide by id of guide with id== null
     *
     * @return error status code
     */
    @Test
    public void getImgGuideById_id_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/auction/api/guide/image/find/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: get list of images of guide by id of guide with id of guide is empty
     *
     * @return error status code
     */
    @Test
    public void getImgGuideById_id_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/auction/api/guide/image/find/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: get list of images of guide by id of guide with id of guide not have in database
     *
     * @return status code no_content, empty list
     */

    @Test
    public void getImgGuideById_id_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/auction/api/guide/image/find/20"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Create by: QuangND,
     * Date created: 14/12/2022
     * Function: get list of images of guide by id of guide with id of guide have in database
     *
     * @return status code success HttpStatus.OK and list img
     */

    @Test
    public void getImgGuideById_id_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/auction/api/guide/image/find/2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("[0].id").value(3))
                .andExpect(jsonPath("[0].url").value("awshjlglsgh.png"))
                .andExpect(jsonPath("[1].id").value(9))
                .andExpect(jsonPath("[1].url").value("kjhrrdhreu.png"))
                .andExpect(jsonPath("[2].id").value(10))
                .andExpect(jsonPath("[2].url").value("testanhdep.jpg"));
    }
}
