package com.project.controller.AccountRestController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountRestController_checkToken {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by: UyenNC
     * Date created: 14/12/2022
     * Function: To test when the token received is null
     */
    @Test
    public void checkToken_token_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/account/token_check?token=null")
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: UyenNC
     * Date created: 14/12/2022
     * Function: To test when the token received is empty
     */
    @Test
    public void checkToken_token_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/account/token_check?token=")
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: UyenNC
     * Date created: 14/12/2022
     * Function: To test when the token received does not exist in database
     */
    @Test
    public void checkToken_token_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/account/token_check?token=abcdef")
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: UyenNC
     * Date created: 14/12/2022
     * Function: To test when the token exists in database but not valid (expired)
     */
    @Test
    public void checkToken_token_99() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/account/token_check?token=ccfc3d50-7fb8-4ea4-9377-bc3e72bab0c0")
                ).andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * Created by: UyenNC
     * Date created: 14/12/2022
     * Function: To test when the token received exists in database and valid (not expired)
     */
    @Test
    public void checkToken_token_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/account/token_check?token=fc5b65f9-5985-48be-bbfe-c661448b773b")
                ).andDo(print())
                .andExpect(status().isMovedPermanently());
    }

}
