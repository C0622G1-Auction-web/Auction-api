package com.project.controller.user;

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
public class UserRestController_getTopAuctionUser {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTopAuctionUser_quality_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/users/top/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * quality #null and quality is number
     * @throws Exception
     */

    @Test
    public void getTopAuctionUser_99() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/users/top/1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * quality #null and quality is number
     * @throws Exception
     */

    @Test
    public void getTopAuctionUser_100() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/users/top/as"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
