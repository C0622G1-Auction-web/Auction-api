package com.project.controller.PaymentRestController;

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
public class PaymentRestController_getPaymentList {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by: UyenNC
     * Date created: 14/12/2022
     * Function: To test the user id when it is null
     */
    @Test
    public void getPaymentList_id_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/payment/v1/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * Created by: UyenNC
     * Date created: 14/12/2022
     * Function: to test the user id when it is empty
     */
    @Test
    public void getPaymentList_id_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/payment/v1?id="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: UyenNC
     * Date created: 14/12/2022
     * Function: to test the user id when it exists in the database
     */
    @Test
    public void getPaymentList_id_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/payment/v1?id=9999"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: UyenNC
     * Date created: 14/12/2022
     * Function: to test the user id when it is empty
     *
     */
    @Test
    public void getPaymentList_id_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/payment/v1?id=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].deleteStatus").value(false))
                .andExpect(jsonPath("content[0].paymentStatus").value(false))
                .andExpect(jsonPath("content[0].shippingDescription").value("Giao tận ngõ"))
                .andExpect(jsonPath("content[0].auction.id").value(8))
                .andExpect(jsonPath("content[7].deleteStatus").value(false))
                .andExpect(jsonPath("content[7].paymentStatus").value(false))
                .andExpect(jsonPath("content[7].shippingDescription").value("Giao tận nhà"))
                .andExpect(jsonPath("content[7].auction.id").value(8));

    }
}
