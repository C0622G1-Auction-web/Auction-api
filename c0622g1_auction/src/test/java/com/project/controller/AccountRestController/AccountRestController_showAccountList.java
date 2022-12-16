package com.project.controller.AccountRestController;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountRestController_showAccountList {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by: UyenNC
     * Date created: 14/12/2022
     * Function: To test when the list return is empty (size = 0)
     */

    @Test
    public void showAccountList_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/v1/account"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: UyenNC
     * Date created: 14/12/2022
     * Function: To test when the list return is not empty (size > 0)
     */
    @Test
    public void showAccountList_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/v1/account"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].deleteStatus").value(0))
                .andExpect(jsonPath("content[0].password").value("$2a$10$gmcH8ky6kl9uyBfT2cx6Ee2iE60DDSq8l3mLewBF.Y4bGTsRiwi.e"))
                .andExpect(jsonPath("content[0].statusLock").value(0))
                .andExpect(jsonPath("content[0].username").value("account123"))
                .andExpect(jsonPath("content[1].id").value(1))
                .andExpect(jsonPath("content[1].deleteStatus").value(0))
                .andExpect(jsonPath("content[1].password").value("$2a$12$/5zhNrx3X8D9b9huZ/KUnejIuzY6yeV.zC3aJaMOin0aJO/uBoSlq"))
                .andExpect(jsonPath("content[1].statusLock").value(0))
                .andExpect(jsonPath("content[1].username").value("daugia06"));
    }


}
