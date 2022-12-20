package com.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dto.user.UserListDto;
import com.project.model.account.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserRestController_unlockUser {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the unlock of field StatusLock
     */
    @Test
    public void test_unlock_fist_name_26() throws Exception {
        UserListDto userListDto = new UserListDto();
        Account account = new Account();
        account.setStatusLock(true);
        userListDto.setAccount(account);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/account/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
