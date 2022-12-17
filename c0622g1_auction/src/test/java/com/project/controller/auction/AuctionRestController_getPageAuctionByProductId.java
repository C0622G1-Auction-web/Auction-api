package com.project.controller.auction;

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
public class AuctionRestController_getPageAuctionByProductId {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by: TienBM,
     * Date created: 14/12/2022
     * Function: get auction listing by id with id value of null
     * @param: null
     */

    @Test
    public void getPageAuctionByProductId_id_7() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/auction/api/product/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: TienBM,
     * Date created: 14/12/2022
     * Function: get auction listing by id with id value of empty
     * @param: do not enter
     */

    @Test
    public void getPageAuctionByProductId_id_8() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/auction/api/product/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: TienBM,
     * Date created: 14/12/2022
     * Function: get auction listing by id with id value does not exist in database
     * @param: 1000
     */

    @Test
    public void getPageAuctionByProductId_id_9() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/auction/api/product/1000"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: TienBM,
     * Date created: 14/12/2022
     * Function: get auction listing by id with valid id value but no element
     * @param: 5
     */

    @Test
    public void getPageAuctionByProductId_id_10() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/auction/api/product/5"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: TienBM,
     * Date created: 14/12/2022
     * Function: get auction listing by id with valid id value and with element
     * @param: 2
     */

    @Test
    public void getPageAuctionByProductId_id_11() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/auction/api/product/2?page=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(5))
                .andExpect(jsonPath("content[0].auctionDay").value("2022-12-16 20:50:00"))
                .andExpect(jsonPath("content[0].currentPrice").value(1000000.0))
                .andExpect(jsonPath("content[0].fullName").value("Nguyen Duy Quang"))
                .andExpect(jsonPath("content[1].auctionDay").value("2022-12-16 20:40:00"))
                .andExpect(jsonPath("content[1].currentPrice").value(900000))
                .andExpect(jsonPath("content[1].fullName").value("Bui Minh Tien"));
    }
}
