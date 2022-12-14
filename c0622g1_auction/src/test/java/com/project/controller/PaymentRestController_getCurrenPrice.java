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
public class PaymentRestController_getCurrenPrice {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by: BaoBC,
     * Date created: 14/12/2022
     * Function: get currenPrice of object payment by id with id value does not exist in database
     * @param: null
     */

    @Test
    public  void  getCurrenPrice_id_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/payment/getCurrenPrice/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: BaoBC,
     * Date created: 14/12/2022
     * Function: get currenPrice of object payment by id with id value does not exist in database
     * @param: do not enter
     */

    @Test
    public  void  getCurrenPrice_id_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/payment/getCurrenPrice/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: BaoBC,
     * Date created: 14/12/2022
     * Function: get currenPrice of object payment by id with id value does not exist in database
     * @param: does not exist
     */

    @Test
    public  void  getCurrenPrice_id_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/payment/getCurrenPrice/1000"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: BaoBC,
     * Date created: 14/12/2022
     * Function: get currenPrice of object payment by id with id value  exist in database
     * @param: exist
     */

    @Test
    public void getCurrenPrice_id_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/payment/getCurrenPrice/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
