package com.project.controller.user;

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
public class UserRestController_getTopAuctionUser {
    @Autowired
    private MockMvc mockMvc;

    /**
     * created: sangDD
     * date:14/12/2022
     * @throws Exception
     */
    @Test
    public void getTopAuctionUser_quality_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/users/top/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * created: sangDD
     * date:14/12/2022
     * @throws Exception
     */
    @Test
    public void getTopAuctionUser_quality_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/users/top/3"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("userTopDtoList[0].name").value("hung"))
                .andExpect(jsonPath("userTopDtoList[1].name").value("quang"))
                .andExpect(jsonPath("userTopDtoList[2].name").value("tuan"));
    }

    /**
     * created: sangDD
     * date:14/12/2022
     * @throws Exception
     * quality is not number
     * @throws Exception
     */
    @Test
    public void getTopAuctionUser_quality_99() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/users/top/a"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * created: sangDD
     * date:14/12/2022
     * @throws Exception
     */
    @Test
    public void getTopAuctionUser_quality_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/users/top/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
