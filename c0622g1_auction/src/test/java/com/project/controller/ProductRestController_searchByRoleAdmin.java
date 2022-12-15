package com.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dto.product.ProductSearchByRoleAdminDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductRestController_searchByRoleAdmin {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method search by role admin uses Dto
     * when Dto is null
     * Result: 400 Bad Request
     */
    @Test
    public void searchByRoleAdmin_30() throws Exception {
        ProductSearchByRoleAdminDto productSearch = null;

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/api/v1/products/search-by-admin")
                        .content(this.objectMapper.writeValueAsString(productSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method search by role admin uses Dto
     * when Dto have null property
     * Result: 204 No Content
     */
    @Test
    public void searchByRoleAdmin_31() throws Exception {
        ProductSearchByRoleAdminDto productSearch = new ProductSearchByRoleAdminDto();
        productSearch.setProductName("Xe");
        productSearch.setAuctionStatusName("Đã đấu giá thành công");
        productSearch.setCategoryName("Xe cộ");
        productSearch.setSellerName("Nguyễn");
        productSearch.setMinPrice(0.0);
        productSearch.setMaxPrice(null);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/api/v1/products/search-by-admin")
                        .content(this.objectMapper.writeValueAsString(productSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method search by role admin uses Dto
     * when Dto property is incorrect format (String property) or not exists in database
     * Result: 204 No Content
     */
    @Test
    public void searchByRoleAdmin_32() throws Exception {
        ProductSearchByRoleAdminDto productSearch = new ProductSearchByRoleAdminDto();
        productSearch.setProductName("@@#@##");
        productSearch.setAuctionStatusName("Đã đấu giá thành công");
        productSearch.setCategoryName("Xe cộ");
        productSearch.setSellerName("Nguyễn");
        productSearch.setMinPrice(0.0);
        productSearch.setMaxPrice(100000000.0);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/api/v1/products/search-by-admin")
                        .content(this.objectMapper.writeValueAsString(productSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /**
     * Created by: GiangLBH
     * Date created: 14/12/2022
     * Function: to test method search by role admin uses Dto
     * when Dto is correct and result exists in database
     */
    @Test
    public void searchByRoleAdmin_33() throws Exception {
        ProductSearchByRoleAdminDto productSearch = new ProductSearchByRoleAdminDto();
        productSearch.setProductName("SH");
        productSearch.setAuctionStatusName("Đã đấu giá thành công");
        productSearch.setCategoryName("Xe cộ");
        productSearch.setSellerName("Nguyễn");
        productSearch.setMinPrice(0.0);
        productSearch.setMaxPrice(100000000.0);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put("/api/v1/products/search-by-admin")
                        .content(this.objectMapper.writeValueAsString(productSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].name").value("SH 150 Nhập 3 cục 2012 Sm 501 59D3-27627"))
                .andExpect(jsonPath("content[0].initialPrice").value(3000000.0))
                .andExpect(jsonPath("content[0].category.name").value("Xe cộ"))
                .andExpect(jsonPath("content[1].name").value("SH 142 73K4-7981 2018 Sm 501"))
                .andExpect(jsonPath("content[1].initialPrice").value(2500000.0))
                .andExpect(jsonPath("content[1].category.name").value("Xe cộ"));

    }






}
