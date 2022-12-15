package com.project.userCreateUpdate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dto.user.UserCreateUpdateDto;
import com.project.model.users.UserType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuctionRestController_createUser {
    @Autowired

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field first name more specific is null
     */
    @Test
    public void createUser_firstName_13() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("");
        userCreateUpdateDto.setLastName("Hai");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field first name more specific is empty
     */
    @Test
    public void createUser_firstName_14() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName(" ");
        userCreateUpdateDto.setLastName("Hai");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field first name more specific is containing special character
     */
    @Test
    public void createUser_firstName_15() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("truong$#%");
        userCreateUpdateDto.setLastName("Hai");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field first name more specific is min length
     */
    @Test
    public void createUser_firstName_16() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("aaa");
        userCreateUpdateDto.setLastName("Hai");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field first name more specific is max length
     */
    @Test
    public void createUser_firstName_17() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        userCreateUpdateDto.setLastName("Hai");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field last name more specific is null
     */
    @Test
    public void createUser_lastName_13() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Le Huu");
        userCreateUpdateDto.setLastName("");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field last name more specific is empty
     */
    @Test
    public void createUser_lastName_14() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field last name more specific is containing special character
     */
    @Test
    public void createUser_lastName_15() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Truong#%$$");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field last name more specific is min length
     */
    @Test
    public void createUser_lastName_16() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("aaa");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field last name more specific is max length
     */
    @Test
    public void createUser_lastName_17() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field email more specific is null
     */
    @Test
    public void createUser_email_13() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Le Huu");
        userCreateUpdateDto.setLastName("Truong");
        userCreateUpdateDto.setEmail("");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field email more specific is empty
     */
    @Test
    public void createUser_email_14() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field email more specific is containing special character
     */
    @Test
    public void createUser_email_15() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Truong#%$$");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field email more specific is min length
     */
    @Test
    public void createUser_email_16() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("aa");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field email more specific is max length
     */
    @Test
    public void createUser_email_17() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field phone more specific is null
     */
    @Test
    public void createUser_phone_13() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Le Huu");
        userCreateUpdateDto.setLastName("Truong");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field phone more specific is empty
     */
    @Test
    public void createUser_phone_14() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field phone more specific is containing special character
     */
    @Test
    public void createUser_phone_15() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("Truong#%$$");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field email more specific is min length
     */
    @Test
    public void createUser_phone_16() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("aa");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field phone more specific is max length
     */
    @Test
    public void createUser_phone_17() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("09111111111111111111111111111");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field dedication more specific is null
     */
    @Test
    public void createUser_pointDedication_13() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Le Huu");
        userCreateUpdateDto.setLastName("Truong");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(null);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field point dedication more specific is empty
     */
    @Test
    public void createUser_pointDedication_14() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(null);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field point dedication smaller <0
     */
    @Test
    public void createUser_pointDedication_16() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(-1.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field point dedication more >100000
     */
    @Test
    public void createUser_pointDedication_17() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(11110000000000.0);
        userCreateUpdateDto.setBirthDay("12-12-2000");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field birth day more specific is null
     */
    @Test
    public void createUser_birthDay_13() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Le Huu");
        userCreateUpdateDto.setLastName("Truong");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field birth day more specific is empty
     */
    @Test
    public void createUser_birthDay_14() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field birth day more specific is containing special character
     */
    @Test
    public void createUser_birthDay_15() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("$$$20-12$-2022");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field birth day more specific is min length
     */
    @Test
    public void createUser_birthDay_16() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("aa");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field birth day more specific is max length
     */
    @Test
    public void createUser_birthDay_17() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("098191360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("111111111111111111111111");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field id card more specific is null
     */
    @Test
    public void createUser_idCard_13() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Le Huu");
        userCreateUpdateDto.setLastName("Truong");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field id card more specific is empty
     */
    @Test
    public void createUser_idCard_14() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field id card more specific is containing special character
     */
    @Test
    public void createUser_idCard_15() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("12%$#1212");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field id card more specific is min length
     */
    @Test
    public void createUser_idCard_16() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2020");
        userCreateUpdateDto.setIdCard("11");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field id card  more specific is max length
     */
    @Test
    public void createUser_idCard_17() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("098191360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2020");
        userCreateUpdateDto.setIdCard("111111111111111111");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field avatar more specific is null
     */
    @Test
    public void createUser_avatar_13() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Le Huu");
        userCreateUpdateDto.setLastName("Truong");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2002");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("null");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field avatar more specific is empty
     */
    @Test
    public void createUser_avatar_14() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184229992");
        userCreateUpdateDto.setAvatar("");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field avatar more specific is containing special character
     */
    @Test
    public void createUser_avatar_15() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184249992");
        userCreateUpdateDto.setAvatar("12%$#1212");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field avatar more specific is min length
     */
    @Test
    public void createUser_avatar_16() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-.1-2020");
        userCreateUpdateDto.setIdCard("184249992");
        userCreateUpdateDto.setAvatar("aa");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field avatar  more specific is max length
     */
    @Test
    public void createUser_avatar_17() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("098191360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2020");
        userCreateUpdateDto.setIdCard("1842499992");
        userCreateUpdateDto.setAvatar("111111111111111111hinhanh");
        userCreateUpdateDto.setDetailAddress("137 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field detail address more specific is null
     */
    @Test
    public void createUser_detailAddress_13() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Le Huu");
        userCreateUpdateDto.setLastName("Truong");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2002");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field detail address more specific is empty
     */
    @Test
    public void createUser_detailAddress_14() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184229992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field detail address more specific is containing special character
     */
    @Test
    public void createUser_detailAddress_15() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184249992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("12%$#1212");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field detailAddress more specific is min length
     */
    @Test
    public void createUser_detailAddress_16() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-.1-2020");
        userCreateUpdateDto.setIdCard("184249992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("aa");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field detail address  more specific is max length
     */
    @Test
    public void createUser_detailAddress_17() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("098191360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2020");
        userCreateUpdateDto.setIdCard("1842499992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field town more specific is null
     */
    @Test
    public void createUser_town_13() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Le Huu");
        userCreateUpdateDto.setLastName("Truong");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2002");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field town more specific is empty
     */
    @Test
    public void createUser_town_14() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184229992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field town more specific is containing special character
     */
    @Test
    public void createUser_town_15() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184249992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("12%$#1212");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field town more specific is min length
     */
    @Test
    public void createUser_town_16() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-.1-2020");
        userCreateUpdateDto.setIdCard("184249992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("aa");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field town  more specific is max length
     */
    @Test
    public void createUser_town_17() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("098191360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2020");
        userCreateUpdateDto.setIdCard("1842499992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hưng");
        userCreateUpdateDto.setTown("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        userCreateUpdateDto.setDistrict("thach ha");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field district more specific is null
     */
    @Test
    public void createUser_district_13() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Le Huu");
        userCreateUpdateDto.setLastName("Truong");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2002");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("thach ha");
        userCreateUpdateDto.setDistrict("");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field district more specific is empty
     */
    @Test
    public void createUser_district_14() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184229992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("thach ha");
        userCreateUpdateDto.setDistrict("");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field district more specific is containing special character
     */
    @Test
    public void createUser_district_15() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184249992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("12%$#1212");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field district more specific is min length
     */
    @Test
    public void createUser_district_16() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-.1-2020");
        userCreateUpdateDto.setIdCard("184249992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("aa");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field district  more specific is max length
     */
    @Test
    public void createUser_district_17() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("098191360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2020");
        userCreateUpdateDto.setIdCard("1842499992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hưng");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field city more specific is null
     */
    @Test
    public void createUser_city_13() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Le Huu");
        userCreateUpdateDto.setLastName("Truong");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2002");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("thach ha");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field city more specific is empty
     */
    @Test
    public void createUser_city_14() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184229992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("thach ha");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field city more specific is containing special character
     */
    @Test
    public void createUser_city_15() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184249992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("12%$#1212");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field city more specific is min length
     */
    @Test
    public void createUser_city_16() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-.1-2020");
        userCreateUpdateDto.setIdCard("184249992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("aa");
        userCreateUpdateDto.setCity("ha tinh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field city  more specific is max length
     */
    @Test
    public void createUser_city_17() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("098191360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2020");
        userCreateUpdateDto.setIdCard("1842499992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hưng");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field country more specific is null
     */
    @Test
    public void createUser_country_13() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Le Huu");
        userCreateUpdateDto.setLastName("Truong");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2002");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("thach ha");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("Ha noi");
        userCreateUpdateDto.setCountry("");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field country more specific is empty
     */
    @Test
    public void createUser_country_14() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184229992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("thach ha");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("ha noi");
        userCreateUpdateDto.setCountry("");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field country more specific is containing special character
     */
    @Test
    public void createUser_country_15() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184249992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("ha noi");
        userCreateUpdateDto.setCountry("12%$#1212");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field country more specific is min length
     */
    @Test
    public void createUser_country_16() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-.1-2020");
        userCreateUpdateDto.setIdCard("184249992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("ha noi");
        userCreateUpdateDto.setCity("aa");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field country  more specific is max length
     */
    @Test
    public void createUser_country_17() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("098191360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2020");
        userCreateUpdateDto.setIdCard("1842499992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hưng");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("ha noi");
        userCreateUpdateDto.setCountry("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field username more specific is null
     */
    @Test
    public void createUser_username_13() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Le Huu");
        userCreateUpdateDto.setLastName("Truong");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2002");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("thach ha");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("Ha noi");
        userCreateUpdateDto.setCountry("vietnam");
        userCreateUpdateDto.setUsername("");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field username more specific is empty
     */
    @Test
    public void createUser_username_14() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184229992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("thach ha");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("ha noi");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field username more specific is containing special character
     */
    @Test
    public void createUser_username_15() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184249992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("ha noi");
        userCreateUpdateDto.setCountry("vietnam");
        userCreateUpdateDto.setUsername("!!!!!!!!!!!!");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field username is exist (is not exist)
     */
    @Test
    public void createUser_username_30() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184249992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("ha noi");
        userCreateUpdateDto.setCountry("vietnam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field username more specific is min length
     */
    @Test
    public void createUser_username_16() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-.1-2020");
        userCreateUpdateDto.setIdCard("184249992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("ha noi");
        userCreateUpdateDto.setCity("ha noi");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("aa");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field username  more specific is max length
     */
    @Test
    public void createUser_username_17() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("098191360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2020");
        userCreateUpdateDto.setIdCard("1842499992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hưng");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("ha noi");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        userCreateUpdateDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field password more specific is null
     */
    @Test
    public void createUser_password_13() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Le Huu");
        userCreateUpdateDto.setLastName("Truong");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2002");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("thach ha");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("Ha noi");
        userCreateUpdateDto.setCountry("Viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field password more specific is empty
     */
    @Test
    public void createUser_password_14() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184229992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("thach ha");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("ha noi");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field password more specific is containing special character
     */
    @Test
    public void createUser_password_15() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184249992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("ha noi");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("1###@3@#2#2##@");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field password more specific is min length
     */
    @Test
    public void createUser_password_16() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-.1-2020");
        userCreateUpdateDto.setIdCard("184249992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("ha noi");
        userCreateUpdateDto.setCity("ha noi");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field password  more specific is max length
     */
    @Test
    public void createUser_password_17() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("098191360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2020");
        userCreateUpdateDto.setIdCard("1842499992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hưng");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("ha noi");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field userTypeName more specific is null
     */
    @Test
    public void createUser_userTypeName_13() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Le Huu");
        userCreateUpdateDto.setLastName("Truong");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2002");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("thach ha");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("Ha noi");
        userCreateUpdateDto.setCountry("Viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("123456789");
        UserType userType = new UserType();
        userType.setName("");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field userTypename more specific is empty
     */
    @Test
    public void createUser_userTypeName_14() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184229992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("thach ha");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("ha noi");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12345678");
        UserType userType = new UserType();
        userType.setName("");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field UserTypeName more specific is containing special character
     */
    @Test
    public void createUser_userTypeName_15() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184249992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("ha noi");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12345678");
        UserType userType = new UserType();
        userType.setName("1###@3@#2#2##@");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field userTypeName more specific is min length
     */
    @Test
    public void createUser_userTypeName_16() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-.1-2020");
        userCreateUpdateDto.setIdCard("184249992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("ha noi");
        userCreateUpdateDto.setCity("ha noi");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12345678");
        UserType userType = new UserType();
        userType.setName("a");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field userTypeName  more specific is max length
     */
    @Test
    public void createUser_userTypeName_17() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("Nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("098191360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2020");
        userCreateUpdateDto.setIdCard("1842499992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hưng");
        userCreateUpdateDto.setTown("ha tay");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("ha noi");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12345678");
        UserType userType = new UserType();
        userType.setName("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field emailList more specific is null
     */
    @Test
    public void createUser_emailList_13() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Le Huu");
        userCreateUpdateDto.setLastName("Truong");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2002");
        userCreateUpdateDto.setIdCard("123456789");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("thach ha");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("Ha noi");
        userCreateUpdateDto.setCountry("Viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("123456789");
        UserType userType = new UserType();
        userType.setName("truongtruong");
        List<String> emailList = new ArrayList<>();
        emailList.add("");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field emailList more specific is empty
     */
    @Test
    public void createUser_emailList_14() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184229992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("thach ha");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("ha noi");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12345678");
        UserType userType = new UserType();
        userType.setName("truongtruong");
        List<String> emailList = new ArrayList<>();
        emailList.add("");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field all right (is complete)
     */
    @Test
    public void createUser_complete_18() throws Exception {
        UserCreateUpdateDto userCreateUpdateDto = new UserCreateUpdateDto();
        userCreateUpdateDto.setId(1);
        userCreateUpdateDto.setFirstName("Lê Hữu");
        userCreateUpdateDto.setLastName("Trường");
        userCreateUpdateDto.setEmail("nguyenthanhhai@gmail.com");
        userCreateUpdateDto.setPhone("0981991360");
        userCreateUpdateDto.setPointDedication(12.0);
        userCreateUpdateDto.setBirthDay("22-01-2022");
        userCreateUpdateDto.setIdCard("184229992");
        userCreateUpdateDto.setAvatar("hinh anh");
        userCreateUpdateDto.setDetailAddress("117 tran duy hung");
        userCreateUpdateDto.setTown("thach ha");
        userCreateUpdateDto.setDistrict("ha tinh");
        userCreateUpdateDto.setCity("ha noi");
        userCreateUpdateDto.setCountry("viet nam");
        userCreateUpdateDto.setUsername("HaiNT");
        userCreateUpdateDto.setPassword("12345678");
        UserType userType = new UserType();
        userType.setName("truongtruong");
        List<String> emailList = new ArrayList<>();
        emailList.add("TruongLHE");
        userCreateUpdateDto.setEmailList(emailList);
        userCreateUpdateDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
