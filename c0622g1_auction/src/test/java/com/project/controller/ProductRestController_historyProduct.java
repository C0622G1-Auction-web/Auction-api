package com.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class ProductRestController_historyProduct {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Created by AnhTDQ
     * Date Created: 14/12/2022
     * Function: to test the page = null => page = 0
     *
     * @throws Exception
     */

    @Test
    public void getListProduct_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/product/list/{id}?page=null"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * Created by AnhTDQ
     * Date Created: 14/12/2022
     * Function: to test the test page ="" => page =0
     *
     * @throws Exception
     */

    @Test
    public void getListProduct_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/product/list/{id}?page="))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * Created by AnhTDQ
     * Date Created: 14/12/2022
     * Function: to test test page = 2 => No content
     *
     * @throws Exception
     */

    @Test
    public void getListProduct_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/product/list/{id}?page=2"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * Created by AnhTDQ
     * Date Created: 14/12/2022
     * Function: to test test test page = 0 => Ok
     *
     * @throws Exception
     */

    @Test
    public void getListProduct_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/product/list/{id}?page=0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(28));
    }


    /**
     * Created by AnhTDQ
     * Date Created: 14/12/2022
     * Function: to test the size = null => size = 0
     *
     * @throws Exception
     */

    @Test
    public void getListProduct_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v3/product/list/{id}?size=null"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * Created by AnhTDQ
     * Date Created: 14/12/2022
     * Function: to test the test size ="" => size =0
     *
     * @throws Exception
     */

    @Test
    public void getListProduct_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/product/list/{id}?size="))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /**
     * Created by AnhTDQ
     * Date Created: 14/12/2022
     * Function: to test size= 2 => No content
     *
     * @throws Exception
     */

    @Test
    public void getListProduct_7() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/product/list/{id}?size=2"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * Created by AnhTDQ
     * Date Created: 14/12/2022
     * Function: to test test test size= 0 => Ok
     *
     * @throws Exception
     */

    @Test
    public void getLisProduct_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/product/list/{id}?size=0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(28));
    }


}
