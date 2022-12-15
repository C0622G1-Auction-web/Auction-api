package com.project.controller.auction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dto.AuctionDto;
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
public class AuctionRestController_addAuction {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Created by: TienBM,
     * Date created: 14/12/2022
     * Function: check new add function of current price field is null
     * @param: do not pass in to check for null
     */

    /**
     * addAuction_currentPrice_14: Cannot be left blank so this case cannot be tested
     * addAuction_currentPrice_15: Can't enter characters other than numbers, so don't test this case
     * addAuction_currentPrice_16: There is no minimum bid amount limit so there is no need to check this case
     * addAuction_currentPrice_17: There is no limit to the maximum bid amount so there is no need to check this case
     */

    @Test
    public void addAuction_currentPrice_13() throws Exception {
        AuctionDto auctionDto = new AuctionDto();
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/auction/api")
                        .content(this.objectMapper.writeValueAsString(auctionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: TienBM,
     * Date created: 14/12/2022
     * Function: check new add function of existing price field with correct value
     * @param: 50000.5
     */

    @Test
    public void addAuction_currentPrice_18() throws Exception {
        AuctionDto auctionDto = new AuctionDto();
        auctionDto.setCurrentPrice(50000.5);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/auction/api")
                        .content(this.objectMapper.writeValueAsString(auctionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
