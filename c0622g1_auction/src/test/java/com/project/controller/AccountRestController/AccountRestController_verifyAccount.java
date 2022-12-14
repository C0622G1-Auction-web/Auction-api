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
public class AccountRestController_verifyAccount {
    @Autowired
    private MockMvc mockMvc;

    /**Created by: UyenNC
     * Date created: 14/12/2022
     * Function To check when email is null
     */
    @Test
    public void verifyAccount_email_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/account/verify_account?username=account123")
        ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**Created by: UyenNC
     * Date created: 14/12/2022
     * Function To check when email is empty
     */
    @Test
    public void verifyAccount_email_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/account/verify_account?email=&username=account123")
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**Created by: UyenNC
     * Date created: 14/12/2022
     * Function To check when email does not exist in database
     */
    @Test
    public void verifyAccount_email_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/account/verify_account?email=somerandom@gmail.com&username=account123")
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**Created by: UyenNC
     * Date created: 14/12/2022
     * Function To check when username is null
     */
    @Test
    public void verifyAccount_username_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/account/verify_account?email=hoathachthaodn97@gmail.com")
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**Created by: UyenNC
     * Date created: 14/12/2022
     * Function To check when username is empty
     */
    @Test
    public void verifyAccount_username_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/account/verify_account?email=hoathachthaodn97@gmail.com&username=")
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**Created by: UyenNC
     * Date created: 14/12/2022
     * Function To check when username does not in database
     */
    @Test
    public void verifyAccount_username_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/account/verify_account?email=hoathachthaodn97@gmail.com&username=somerandom")
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**Created by: UyenNC
     * Date created: 14/12/2022
     * Function To check when both email and username are valid and exist in database
     */
    @Test
    public void verifyAccount_username_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/account/verify_account?email=hoathachthaodn97@gmail.com&username=account123")
                ).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
