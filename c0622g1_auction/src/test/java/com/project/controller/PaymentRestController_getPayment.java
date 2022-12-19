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
public class PaymentRestController_getPayment {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by: ChauPTM
     * Date created: 14/12/2022
     * Function: to test the payment id when it is null
     */
    @Test
    public void getPayment_id_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/payment/v1/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: ChauPTM
     * Date created: 14/12/2022
     * Function: to test the payment id when it empties
     */
    @Test
    public void getPayment_id_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/payment/v1?id="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: ChauPTM
     * Date created: 14/12/2022
     * Function: to test the payment id, but it doesn't exist in Database
     */
    @Test
    public void getPayment_id_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/payment/v1/9"))
                .andDo(print())
                .andExpect(status().is(204));
    }

    /**
     * Created by: ChauPTM
     * Date created: 14/12/2022
     * Function: to test the payment id, but it exists in Database
     */
    @Test
    public void getPayment_id_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/payment/v1/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("deleteStatus").value(false))
                .andExpect(jsonPath("paymentStatus").value(false))
                .andExpect(jsonPath("shippingDescription").value("Giao tận ngõ"))
                .andExpect(jsonPath("auctionId").value(8));
    }
}
