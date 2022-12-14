package com.project.controller.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dto.product.ProductSearchDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductRestController_getAllAndSearch {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Created: SangDD
     * Date: 14/12/2022
     * function: auction_status_id is not database
     * @throws Exception
     */
    @Test
    public void getAllAndSearch_auction_status_id_9() throws Exception {
        ProductSearchDto productSearchDto = new ProductSearchDto();
        productSearchDto.setName("");
        productSearchDto.setCategoryID("");
        productSearchDto.setRangePrice("0");
        productSearchDto.setProductAuctionStatus("10");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/products/search")
                        .content(this.objectMapper.writeValueAsString(productSearchDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created: SangDD
     * Date: 14/12/2022
     * function: category_id is not database
     * @throws Exception
     */
    @Test
    public void getAllAndSearch_category_id_9() throws Exception {
        ProductSearchDto productSearchDto = new ProductSearchDto();
        productSearchDto.setName("");
        productSearchDto.setCategoryID("");
        productSearchDto.setRangePrice("0");
        productSearchDto.setProductAuctionStatus("10");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/products/search")
                        .content(this.objectMapper.writeValueAsString(productSearchDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getAllAndSearch_11() throws Exception {
        ProductSearchDto productSearchDto = new ProductSearchDto();
        productSearchDto.setName("ban");
        productSearchDto.setCategoryID("");
        productSearchDto.setRangePrice("0");
        productSearchDto.setProductAuctionStatus("");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/products/search")
                        .content(this.objectMapper.writeValueAsString(productSearchDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].name").value("xe gia đình cần bán"))
                .andExpect(jsonPath("content[0].initialPrice").value("5000000"))
                .andExpect(jsonPath("content[1].initialPrice").value("800000"))
                .andExpect(jsonPath("content[1].name").value("BÀN TRÀ APU BV4"));
    }
}
