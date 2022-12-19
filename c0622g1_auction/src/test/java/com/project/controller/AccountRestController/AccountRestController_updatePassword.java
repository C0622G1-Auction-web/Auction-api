package com.project.controller.AccountRestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.account.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountRestController_updatePassword {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**Created by: UyenNC
     * Date created: 14/12/2022
     * Function To check when password is null
     */

    @Test
    public void updatePassword_password_19() throws Exception {
        Account account = new Account();
        account.setId(1);
        account.setStatusLock(false);
        account.setDeleteStatus(false);
        account.setPassword(null);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/account/update_pass/1")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isNotAcceptable());
    }
    /**Created by: UyenNC
     * Date created: 14/12/2022
     * Function To check when password is empty
     */
    @Test
    public void updatePassword_password_20() throws Exception {
        Account account = new Account();
        account.setId(1);
        account.setStatusLock(false);
        account.setDeleteStatus(false);
        account.setPassword("");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/account/update_pass/1")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isNotAcceptable());
    }
    /**Created by: UyenNC
     * Date created: 14/12/2022
     * Function To check when password length is smaller than required
     */
    @Test
    public void updatePassword_password_22() throws Exception {
        Account account = new Account();
        account.setId(1);
        account.setStatusLock(false);
        account.setDeleteStatus(false);
        account.setPassword("ab");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/account/update_pass/1")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isNotAcceptable());
    }

    /**Created by: UyenNC
     * Date created: 14/12/2022
     * Function To check when password length is bigger than required
     */
    @Test
    public void updatePassword_password_23() throws Exception {
        Account account = new Account();
        account.setId(1);
        account.setStatusLock(false);
        account.setDeleteStatus(false);
        account.setPassword("abcdefghijklmnoppabcdefghijklmnoppabcde" +
                "fghijklmnoppabcdefghijklmnoppabcdefghijklmnoppabcdefghi" +
                "jklmnoppabcdefghijklmnoppabcdefghijklmnoppabcdefghijklmnopp" +
                "abcdefghijklmnoppabcdefghijklmnoppabcdefghijklmnoppabcdefghijkl" +
                "mnoppabcdefghijklmnoppabcdefghijklmnoppabcdefghijklmnopp");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/account/update_pass/1")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isNotAcceptable());
    }
    /**Created by: UyenNC
     * Date created: 14/12/2022
     * Function To check when password is valid and is saved in database
     */
    @Test
    public void updatePassword_password_24() throws Exception {
        Account account = new Account();
        account.setId(1);
        account.setStatusLock(false);
        account.setDeleteStatus(false);
        account.setPassword("matkhaudaugia123@");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/account/update_pass/1")
                        .content(this.objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
