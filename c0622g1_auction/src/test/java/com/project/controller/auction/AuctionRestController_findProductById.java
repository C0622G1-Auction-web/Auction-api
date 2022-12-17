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
public class AuctionRestController_findProductById {
    @Autowired
    MockMvc mockMvc;

    /**
     * Created by: TienBM,
     * Date created: 14/12/2022
     * Function: product search by id with id value null
     * @param: null
     */

    @Test
    public void findProductById_id_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/auction/api/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: TienBM,
     * Date created: 14/12/2022
     * Function: product search by id with id value empty
     * @param: do not enter
     */

    @Test
    public void findProductById_id_2() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/auction/api/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: TienBM,
     * Date created: 14/12/2022
     * Function: product search by id with id value does not exist in database
     * @param: 500
     */

    @Test
    public void findProductById_id_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/auction/api/500"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: TienBM,
     * Date created: 14/12/2022
     * Function: product search by id with correct id value
     * @param: 2
     */

    @Test
    public void findProductById_id_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/auction/api/2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("name").value("BÀN TRÀ APU BV4"))
                .andExpect(jsonPath("initialPrice").value(800000.0))
                .andExpect(jsonPath("priceStep.id").value(2));
    }
}
