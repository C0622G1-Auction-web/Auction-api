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
public class TransactionRestController_getListTransaction {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by : HuyNV,
     * Date created: 14/12/2022
     * Function: List transaction no found
     *
     * @throws Exception
     */
    @Test
    public void getListTransaction_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/auction/v1/transaction"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by : HuyNV,
     * Date created: 14/12/2022
     * Function: List transaction
     *
     * @throws Exception
     */
    @Test
    public void getListTransaction_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/auction/v1/transaction?page=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(3))
                .andExpect(jsonPath("totalElements").value(11))
                .andExpect(jsonPath("content[0].currentPrice").value("4000000.0"))
                .andExpect(jsonPath("content[0].auctionDay").value("2022-12-18 20:30:00"))
                .andExpect(jsonPath("content[0].auctionTime").value("0"))
                .andExpect(jsonPath("content[4].currentPrice").value("5500000.0"))
                .andExpect(jsonPath("content[4].auctionDay").value("2022-12-24 20:30:00"))
                .andExpect(jsonPath("content[4].auctionTime").value("0"));
    }
}
