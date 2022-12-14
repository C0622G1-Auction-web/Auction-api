package com.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.product.AuctionStatus;
import com.project.model.product.Category;
import com.project.model.product.PriceStep;
import com.project.model.product.ReviewStatus;
import com.project.model.product.dto.*;
import com.project.model.users.User;
import com.project.model.users.dto.UserDTO;
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
public class ProductRestController_createProduct {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * this function use to test the validation of field name more specific is null
     */
    @Test
    public void create_name_13() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setInitialPrice(1000000.0);
        productDTO.setDescription("Máy đẹp");
        productDTO.setStartTime("2022-12-20 11:00:00");
        productDTO.setEndTime("2022-12-25 11:00:00");
        productDTO.setRegisterDay("2022-12-15");
        productDTO.setUser(2);
        productDTO.setReviewStatus(1);
        productDTO.setAuctionStatus(1);
        productDTO.setPriceStep(2);
        productDTO.setCategory(2);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/products/create")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * this function use to test the validation of field name more specific is blank
     */
    @Test
    public void create_name_14() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("");
        productDTO.setInitialPrice(1000000.0);
        productDTO.setDescription("Máy đẹp");
        productDTO.setStartTime("2022-12-20 11:00:00");
        productDTO.setEndTime("2022-12-25 11:00:00");
        productDTO.setRegisterDay("2022-12-15");
        productDTO.setUser(2);
        productDTO.setReviewStatus(1);
        productDTO.setAuctionStatus(1);
        productDTO.setPriceStep(2);
        productDTO.setCategory(2);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/products/create/")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * this function use to test the validation of field name more specific is regexp
     */
    @Test
    public void create_name_15() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("A123123asAA  A");
        productDTO.setInitialPrice(1000000.0);
        productDTO.setDescription("Máy đẹp");
        productDTO.setStartTime("2022-12-20 11:00:00");
        productDTO.setEndTime("2022-12-25 11:00:00");
        productDTO.setRegisterDay("2022-12-15");

        productDTO.setUser(2);
        productDTO.setReviewStatus(1);
        productDTO.setAuctionStatus(1);
        productDTO.setPriceStep(1);
        productDTO.setCategory(2);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/products/create/")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * this function use to test the validation of field name min length < 5
     */
    @Test
    public void create_name_16() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Iph");
        productDTO.setInitialPrice(1000000.0);
        productDTO.setDescription("Máy đẹp");
        productDTO.setStartTime("2022-12-20 11:00:00");
        productDTO.setEndTime("2022-12-25 11:00:00");
        productDTO.setRegisterDay("2022-12-15");
        productDTO.setUser(2);
        productDTO.setReviewStatus(1);
        productDTO.setAuctionStatus(1);
        productDTO.setPriceStep(2);
        productDTO.setCategory(2);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/products/create/")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * this function use to test the validation of field name max length < 255
     */
    @Test
    public void create_name_17() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        productDTO.setInitialPrice(1000000.0);
        productDTO.setDescription("Máy đẹp");
        productDTO.setStartTime("2022-12-20 11:00:00");
        productDTO.setEndTime("2022-12-25 11:00:00");
        productDTO.setRegisterDay("2022-12-15");
        productDTO.setUser(2);
        productDTO.setReviewStatus(1);
        productDTO.setAuctionStatus(1);
        productDTO.setPriceStep(2);
        productDTO.setCategory(2);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/products/create/")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * this function use to test create new successfully
     */
    @Test
    public void create_name_18() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Ghế Công Thái Học");
        productDTO.setInitialPrice(1000000.0);
        productDTO.setDescription("Máy đẹp");
        productDTO.setStartTime("2022-12-20 11:00:00");
        productDTO.setEndTime("2022-12-25 11:00:00");
        productDTO.setRegisterDay("2022-12-15");
        productDTO.setUser(2);
        productDTO.setReviewStatus(1);
        productDTO.setAuctionStatus(1);
        productDTO.setPriceStep(2);
        productDTO.setCategory(2);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/products/create/")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * this function use to test the validation of field initialPrice more specific is null
     */
    @Test
    public void create_initialPrice_13() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Ghế Công Thái Học");
        productDTO.setDescription("Máy đẹp");
        productDTO.setStartTime("2022-12-20 11:00:00");
        productDTO.setEndTime("2022-12-25 11:00:00");
        productDTO.setRegisterDay("2022-12-15");
        productDTO.setUser(2);
        productDTO.setReviewStatus(1);
        productDTO.setAuctionStatus(1);
        productDTO.setPriceStep(2);
        productDTO.setCategory(2);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/products/create/")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * this function use to test the validation of field initialPrice is regexp
     */
    @Test
    public void create_initialPrice_15() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Ghế Công Thái Học");
        productDTO.setInitialPrice(-1.0);
        productDTO.setDescription("Máy đẹp");
        productDTO.setStartTime("2022-12-20 11:00:00");
        productDTO.setEndTime("2022-12-25 11:00:00");
        productDTO.setRegisterDay("2022-12-15");
        productDTO.setUser(2);
        productDTO.setReviewStatus(1);
        productDTO.setAuctionStatus(1);
        productDTO.setPriceStep(2);
        productDTO.setCategory(2);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/products/create/")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * this function use to test the validation of field initialPrice max length
     */
    @Test
    public void create_initialPrice_17() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Ghế Công Thái Học");
        productDTO.setInitialPrice(11111111111111111111111111111111111111111111111111111.0);
        productDTO.setDescription("Máy đẹp");
        productDTO.setStartTime("2022-12-20 11:00:00");
        productDTO.setEndTime("2022-12-25 11:00:00");
        productDTO.setRegisterDay("2022-12-15");
        productDTO.setUser(2);
        productDTO.setReviewStatus(1);
        productDTO.setAuctionStatus(1);
        productDTO.setPriceStep(2);
        productDTO.setCategory(2);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/products/create/")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * this function use to test the validation of field description more specific is null
     */
    @Test
    public void create_description_13() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Ghế Công Thái Học");
        productDTO.setInitialPrice(100000.0);
        productDTO.setDescription("");
        productDTO.setStartTime("2022-12-20 11:00:00");
        productDTO.setEndTime("2022-12-25 11:00:00");
        productDTO.setRegisterDay("2022-12-15");
        productDTO.setUser(2);
        productDTO.setReviewStatus(1);
        productDTO.setAuctionStatus(1);
        productDTO.setPriceStep(2);
        productDTO.setCategory(2);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/products/create/")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * this function use to test the validation of field description more specific is blank
     */
    @Test
    public void create_description_14() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Ghế Công Thái Học");
        productDTO.setInitialPrice(100000.0);
        productDTO.setStartTime("2022-12-20 11:00:00");
        productDTO.setEndTime("2022-12-25 11:00:00");
        productDTO.setRegisterDay("2022-12-15");
        productDTO.setUser(2);
        productDTO.setReviewStatus(1);
        productDTO.setAuctionStatus(1);
        productDTO.setPriceStep(2);
        productDTO.setCategory(2);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/products/create/")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * this function use to test the validation of field description min length
     */
    @Test
    public void create_description_16() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Ghế Công Thái Học");
        productDTO.setInitialPrice(100000.0);
        productDTO.setDescription("Abc");
        productDTO.setStartTime("2022-12-20 11:00:00");
        productDTO.setEndTime("2022-12-25 11:00:00");
        productDTO.setRegisterDay("2022-12-15");
        productDTO.setUser(2);
        productDTO.setReviewStatus(1);
        productDTO.setAuctionStatus(1);
        productDTO.setPriceStep(2);
        productDTO.setCategory(2);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/products/create/")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * this function use to test the validation of field description max length
     */
    @Test
    public void create_description_17() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Ghế Công Thái Học");
        productDTO.setInitialPrice(100000.0);
        productDTO.setDescription("AbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbc" +
                "AbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbc" +
                "AbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbc" +
                "AbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbc" +
                "AbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbc" +
                "AbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbc" +
                "AbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbc" +
                "AbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbcAbc");
        productDTO.setStartTime("2022-12-20 11:00:00");
        productDTO.setEndTime("2022-12-25 11:00:00");
        productDTO.setRegisterDay("2022-12-15");
        productDTO.setUser(2);
        productDTO.setReviewStatus(1);
        productDTO.setAuctionStatus(1);
        productDTO.setPriceStep(2);
        productDTO.setCategory(2);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/products/create/")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * this function use to test the validation of field startTime more specific is blank
     */
    @Test
    public void create_startTime_14() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Ghế Công Thái Học");
        productDTO.setInitialPrice(100000.0);
        productDTO.setDescription("Hàng chính hãng");
        productDTO.setStartTime("");
        productDTO.setEndTime("2022-12-25 11:00:00");
        productDTO.setRegisterDay("2022-12-15");
        productDTO.setUser(2);
        productDTO.setReviewStatus(1);
        productDTO.setAuctionStatus(1);
        productDTO.setPriceStep(2);
        productDTO.setCategory(2);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/products/create/")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * this function use to test the validation of field endTime more specific is blank
     */
    @Test
    public void create_endTime_14() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Ghế Công Thái Học");
        productDTO.setInitialPrice(100000.0);
        productDTO.setDescription("Hàng chính hãng");
        productDTO.setStartTime("2022-12-25 11:00:00");
        productDTO.setEndTime("");
        productDTO.setRegisterDay("2022-12-15");
        productDTO.setUser(2);
        productDTO.setReviewStatus(1);
        productDTO.setAuctionStatus(1);
        productDTO.setPriceStep(2);
        productDTO.setCategory(2);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/products/create/")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HungNV,
     * Date created: 14/12/2022
     * this function use to test the validation of field user more specific is null
     */
    @Test
    public void create_user_13() throws Exception {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Ghế Công Thái Học");
        productDTO.setInitialPrice(100000.0);
        productDTO.setDescription("Hàng chính hãng");
        productDTO.setStartTime("2022-12-25 11:00:00");
        productDTO.setEndTime("");
        productDTO.setRegisterDay("2022-12-15");
        productDTO.setReviewStatus(1);
        productDTO.setAuctionStatus(1);
        productDTO.setPriceStep(2);
        productDTO.setCategory(2);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/v1/products/create/")
                        .content(this.objectMapper.writeValueAsString(productDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
