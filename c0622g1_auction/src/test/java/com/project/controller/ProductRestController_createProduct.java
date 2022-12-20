//package com.project.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.project.dto.product.CategoryDto;
//import com.project.dto.product.PriceStepDto;
//import com.project.dto.product.ProductDto;
//import com.project.dto.user.UserDto;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ProductRestController_createProduct {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    /**
//     * this function use to test the validation of field name more specific is null
//     *
//     * @author SonPT
//     * @Time 11:14 14/12/2022
//     */
//
//    @Test
//    public void createProduct_name_13() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setDescription("This is color yellow");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field name more specific is blank
//     *
//     * @author SonPT
//     * @Time 11:29 14/12/2022
//     */
//
//    @Test
//    public void createProduct_name_14() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("");
//        productDto.setDescription("This is color yellow");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field name more specific is containing special character and
//     the first letters are not capitalized
//     *
//     * @author SonPT
//     * @Time 11:32 14/12/2022
//     */
//
//    @Test
//    public void createProduct_name_15() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("túi xách LV #$@@$$");
//        productDto.setDescription("This is color yellow");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field name more specific is min length
//     *
//     * @author SonPT
//     * @Time 11:32 14/12/2022
//     */
//
//    @Test
//    public void createProduct_name_16() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("t");
//        productDto.setDescription("This is color yellow");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field name more specific is max length
//     *
//     * @author SonPT
//     * @Time 11:33 14/12/2022
//     */
//
//    @Test
//    public void createProduct_name_17() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("thhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
//        productDto.setDescription("This is color yellow");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field name exactly
//     *
//     * @author SonPT
//     * @Time 11:34 14/12/2022
//     */
//
//    @Test
//    public void createProduct_name_18() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//
//        productDto.setName("Nguyễn Thị Tuyết Hảo");
//        productDto.setDescription("This is color yellow");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    /**
//     * this function use to test the validation of field description more specific is null
//     *
//     * @author SonPT
//     * @Time 11:51 14/12/2022
//     */
//
//    @Test
//    public void createProduct_description_13() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field description more specific is blank
//     *
//     * @author SonPT
//     * @Time 11:29 14/12/2022
//     */
//
//    @Test
//    public void createProduct_description_14() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field description more specific is containing special character and
//     the first letters are not capitalized
//     *
//     * @author SonPT
//     * @Time 13:30 14/12/2022
//     */
//
//    @Test
//    public void createProduct_description_15() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("audauu @#$%");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field description more specific is min length
//     *
//     * @author SonPT
//     * @Time 11:32 14/12/2022
//     */
//
//    @Test
//    public void createProduct_description_16() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("Th");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field description exactly
//     *
//     * @author SonPT
//     * @Time 11:34 14/12/2022
//     */
//
//    @Test
//    public void createProduct_description_18() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("This is color yellow");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    /**
//     * this function use to test the validation of field initialPrice more specific is null
//     *
//     * @author SonPT
//     * @Time 13:34 14/12/2022
//     */
//
//    @Test
//    public void createProduct_initialPrice_13() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field initialPrice more specific is min length
//     *
//     * @author SonPT
//     * @Time 11:32 14/12/2022
//     */
//
//    @Test
//    public void createProduct_initialPrice_16() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("Thì ra đây là description");
//        productDto.setInitialPrice(0.0);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field initialPrice exactly
//     *
//     * @author SonPT
//     * @Time 11:34 14/12/2022
//     */
//
//    @Test
//    public void createProduct_initialPrice_18() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("This is color yellow");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    /**
//     * this function use to test the validation of field startTime more specific is null
//     *
//     * @author SonPT
//     * @Time 13:40 14/12/2022
//     */
//
//    @Test
//    public void createProduct_startTime_13() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setStartTime("Thì ra đây là description");
//        productDto.setInitialPrice(4444.4);
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field startTime more specific is blank
//     *
//     * @author SonPT
//     * @Time 11:29 14/12/2022
//     */
//
//    @Test
//    public void createProduct_startTime_14() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("Thì ra đây là description");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field startTime more specific is containing special character and
//     *
//     * @author SonPT
//     * @Time 13:30 14/12/2022
//     */
//
//    @Test
//    public void createProduct_startTime_15() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("Thì ra đây là description");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999 @@###");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field startTime is wrong format dd/MM/yyyy
//     *
//     * @author SonPT
//     * @Time 13:42 14/12/2022
//     */
//
//    @Test
//    public void createProduct_startTime_15_2() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("Thì ra đây là description");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("2022-13-12");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field startTime more specific is min length
//     *
//     * @author SonPT
//     * @Time 11:32 14/12/2022
//     */
//
//    @Test
//    public void createProduct_startTime_16() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("Thì ra đây là description");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field startTime exactly
//     *
//     * @author SonPT
//     * @Time 11:34 14/12/2022
//     */
//
//    @Test
//    public void createProduct_startTime_18() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("This is color yellow");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    /**
//     * this function use to test the validation of field endTime more specific is null
//     *
//     * @author SonPT
//     * @Time 13:40 14/12/2022
//     */
//
//    @Test
//    public void createProduct_endTime_13() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setStartTime("Thì ra đây là description");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field endTime more specific is blank
//     *
//     * @author SonPT
//     * @Time 11:29 14/12/2022
//     */
//
//    @Test
//    public void createProduct_endTime_14() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("Thì ra đây là description");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-08-1999");
//        productDto.setEndTime("");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field endTime more specific is containing special character and
//     *
//     * @author SonPT
//     * @Time 13:30 14/12/2022
//     */
//
//    @Test
//    public void createProduct_endTime_15() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("Thì ra đây là description");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999 @@###");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field endTime is wrong format dd/MM/yyyy
//     *
//     * @author SonPT
//     * @Time 13:42 14/12/2022
//     */
//
//    @Test
//    public void createProduct_endTime_15_2() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("Thì ra đây là description");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-05-1999 ");
//        productDto.setEndTime("2022-13-12");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field endTime more specific is min length
//     *
//     * @author SonPT
//     * @Time 11:32 14/12/2022
//     */
//
//    @Test
//    public void createProduct_endTime_16() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("Thì ra đây là description");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-05-1999");
//        productDto.setEndTime("12");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field endTime exactly
//     *
//     * @author SonPT
//     * @Time 11:34 14/12/2022
//     */
//
//    @Test
//    public void createProduct_endTime_18() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("This is color yellow");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    /**
//     * this function use to test the validation of field price Step more specific is null
//     *
//     * @author SonPT
//     * @Time 14:57 14/12/2022
//     */
//
//    @Test
//    public void createProduct_priceStep_13() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setStartTime("Thì ra đây là description");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-04-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field price Step more specific is not in Database
//     *
//     * @author SonPT
//     * @Time 15:06 14/12/2022
//     */
//
//    @Test
//    public void createProduct_priceStep_15() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("Thì ra đây là description");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(7);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field price Step exactly
//     *
//     * @author SonPT
//     * @Time 15:06 14/12/2022
//     */
//
//    @Test
//    public void createProduct_priceStep_18() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("This is color yellow");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    /**
//     * this function use to test the validation of field category more specific is null
//     *
//     * @author SonPT
//     * @Time 15:07 14/12/2022
//     */
//
//    @Test
//    public void createProduct_category_13() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setStartTime("Thì ra đây là description");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-04-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field category more specific is not in Database
//     *
//     * @author SonPT
//     * @Time 15:06 14/12/2022
//     */
//
//    @Test
//    public void createProduct_category_15() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("Thì ra đây là description");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(7);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(7);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field category exactly
//     *
//     * @author SonPT
//     * @Time 15:06 14/12/2022
//     */
//
//    @Test
//    public void createProduct_category_18() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("This is color yellow");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//
//
//
//
//
//
//    /**
//     * this function use to test the validation of field user more specific is null
//     *
//     * @author SonPT
//     * @Time 15:09 14/12/2022
//     */
//
//    @Test
//    public void createProduct_user_13() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setStartTime("Thì ra đây là description");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-04-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field user more specific is not in Database
//     *
//     * @author SonPT
//     * @Time 15:06 14/12/2022
//     */
//
//    @Test
//    public void createProduct_user_15() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("Thì ra đây là description");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(9);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(7);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }
//
//    /**
//     * this function use to test the validation of field user exactly
//     *
//     * @author SonPT
//     * @Time 15:06 14/12/2022
//     */
//
//    @Test
//    public void createProduct_user_18() throws Exception {
//
//        ProductDto productDto = new ProductDto();
//
//        productDto.setName("Phạm Thế Sơn");
//        productDto.setDescription("This is color yellow");
//        productDto.setInitialPrice(4444.4);
//        productDto.setStartTime("12-04-1999");
//        productDto.setEndTime("12-05-1999");
//
//        CategoryDto categoryDto = new CategoryDto();
//        categoryDto.setId(2);
//        productDto.setCategory(categoryDto);
//
//        PriceStepDto priceStepDto = new PriceStepDto();
//        priceStepDto.setId(2);
//        productDto.setPriceStep(priceStepDto);
//
//        UserDto userDto = new UserDto();
//        userDto.setId(2);
//        productDto.setUser(userDto);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders
//                        .post("/api/v1/products/create")
//                        .content(this.objectMapper.writeValueAsString(productDto))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
//    }
//}
