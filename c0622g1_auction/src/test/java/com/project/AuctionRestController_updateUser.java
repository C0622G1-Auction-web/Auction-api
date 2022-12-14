package com.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dto.user.UserDto;
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
public class AuctionRestController_updateUser {
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
    public void updateUser_firstName_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("");
        userDto.setLastName("Hai");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_firstName_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName(" ");
        userDto.setLastName("Hai");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_firstName_21() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("truong$#%");
        userDto.setLastName("Hai");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_firstName_22() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("aaa");
        userDto.setLastName("Hai");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_firstName_23() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        userDto.setLastName("Hai");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_lastName_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Le Huu");
        userDto.setLastName("");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_lastName_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_lastName_21() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Truong#%$$");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_lastName_22() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("aaa");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_lastName_23() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_email_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Le Huu");
        userDto.setLastName("Truong");
        userDto.setEmail("");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_email_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_email_21() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Truong#%$$");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_email_22() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("aa");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_email_23() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_phone_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Le Huu");
        userDto.setLastName("Truong");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_phone_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_phone_21() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("Truong#%$$");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_phone_22() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("aa");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_phone_23() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("09111111111111111111111111111");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_pointDedication_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Le Huu");
        userDto.setLastName("Truong");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(null);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_pointDedication_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(null);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_pointDedication_21() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(-1.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_pointDedication_22() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(11110000000000.0);
        userDto.setBirthDay("12-12-2000");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_birthDay_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Le Huu");
        userDto.setLastName("Truong");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_birthDay_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_birthDay_21() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("$$$20-12$-2022");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_birthDay_22() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("aa");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_birthDay_23() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("098191360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("111111111111111111111111");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_idCard_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Le Huu");
        userDto.setLastName("Truong");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_idCard_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_idCard_21() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("12%$#1212");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_idCard_22() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2020");
        userDto.setIdCard("11");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_idCard_23() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("098191360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2020");
        userDto.setIdCard("111111111111111111");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_avatar_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Le Huu");
        userDto.setLastName("Truong");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2002");
        userDto.setIdCard("123456789");
        userDto.setAvatar("null");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_avatar_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184229992");
        userDto.setAvatar("");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_avatar_21() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184249992");
        userDto.setAvatar("12%$#1212");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_avatar_22() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-.1-2020");
        userDto.setIdCard("184249992");
        userDto.setAvatar("aa");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_avatar_23() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("098191360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2020");
        userDto.setIdCard("1842499992");
        userDto.setAvatar("111111111111111111hinhanh");
        userDto.setDetailAddress("137 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_detailAddress_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Le Huu");
        userDto.setLastName("Truong");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2002");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_detailAddress_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184229992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_detailAddress_21() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184249992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("12%$#1212");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_detailAddress_22() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-.1-2020");
        userDto.setIdCard("184249992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("aa");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_detailAddress_23() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("098191360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2020");
        userDto.setIdCard("1842499992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        userDto.setTown("ha tay");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_town_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Le Huu");
        userDto.setLastName("Truong");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2002");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_town_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184229992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_town_21() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184249992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("12%$#1212");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_town_22() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-.1-2020");
        userDto.setIdCard("184249992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("aa");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_town_23() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("098191360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2020");
        userDto.setIdCard("1842499992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hưng");
        userDto.setTown("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        userDto.setDistrict("thach ha");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_district_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Le Huu");
        userDto.setLastName("Truong");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2002");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("thach ha");
        userDto.setDistrict("");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_district_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184229992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("thach ha");
        userDto.setDistrict("");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_district_21() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184249992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("12%$#1212");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_district_22() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-.1-2020");
        userDto.setIdCard("184249992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("aa");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_district_23() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("098191360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2020");
        userDto.setIdCard("1842499992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hưng");
        userDto.setTown("ha tay");
        userDto.setDistrict("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_city_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Le Huu");
        userDto.setLastName("Truong");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2002");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("thach ha");
        userDto.setDistrict("ha tinh");
        userDto.setCity("");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_city_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184229992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("thach ha");
        userDto.setDistrict("ha tinh");
        userDto.setCity("");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_city_21() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184249992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("ha tinh");
        userDto.setCity("12%$#1212");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_city_22() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-.1-2020");
        userDto.setIdCard("184249992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("aa");
        userDto.setCity("ha tinh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_city_23() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("098191360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2020");
        userDto.setIdCard("1842499992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hưng");
        userDto.setTown("ha tay");
        userDto.setDistrict("ha tinh");
        userDto.setCity("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_country_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Le Huu");
        userDto.setLastName("Truong");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2002");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("thach ha");
        userDto.setDistrict("ha tinh");
        userDto.setCity("Ha noi");
        userDto.setCountry("");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_country_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184229992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("thach ha");
        userDto.setDistrict("ha tinh");
        userDto.setCity("ha noi");
        userDto.setCountry("");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_country_21() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184249992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("ha tinh");
        userDto.setCity("ha noi");
        userDto.setCountry("12%$#1212");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_country_22() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-.1-2020");
        userDto.setIdCard("184249992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("ha noi");
        userDto.setCity("aa");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_country_23() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("098191360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2020");
        userDto.setIdCard("1842499992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hưng");
        userDto.setTown("ha tay");
        userDto.setDistrict("ha tinh");
        userDto.setCity("ha noi");
        userDto.setCountry("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_username_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Le Huu");
        userDto.setLastName("Truong");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2002");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("thach ha");
        userDto.setDistrict("ha tinh");
        userDto.setCity("Ha noi");
        userDto.setCountry("vietnam");
        userDto.setUsername("");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_username_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184229992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("thach ha");
        userDto.setDistrict("ha tinh");
        userDto.setCity("ha noi");
        userDto.setCountry("viet nam");
        userDto.setUsername("");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_username_21() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184249992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("ha tinh");
        userDto.setCity("ha noi");
        userDto.setCountry("vietnam");
        userDto.setUsername("!!!!!!!!!!!!");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: TruongLH
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field username is exist (is  could not exist)
     */
    @Test
    public void updateUser_username_30() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184249992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("ha tinh");
        userDto.setCity("ha noi");
        userDto.setCountry("vietnam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_username_22() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-.1-2020");
        userDto.setIdCard("184249992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("ha noi");
        userDto.setCity("ha noi");
        userDto.setCountry("viet nam");
        userDto.setUsername("aa");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_username_23() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("098191360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2020");
        userDto.setIdCard("1842499992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hưng");
        userDto.setTown("ha tay");
        userDto.setDistrict("ha tinh");
        userDto.setCity("ha noi");
        userDto.setCountry("viet nam");
        userDto.setUsername("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        userDto.setPassword("12341234");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_password_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Le Huu");
        userDto.setLastName("Truong");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2002");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("thach ha");
        userDto.setDistrict("ha tinh");
        userDto.setCity("Ha noi");
        userDto.setCountry("Viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_password_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184229992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("thach ha");
        userDto.setDistrict("ha tinh");
        userDto.setCity("ha noi");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_password_21() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184249992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("ha tinh");
        userDto.setCity("ha noi");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("1###@3@#2#2##@");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_password_22() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-.1-2020");
        userDto.setIdCard("184249992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("ha noi");
        userDto.setCity("ha noi");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_password_23() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("098191360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2020");
        userDto.setIdCard("1842499992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hưng");
        userDto.setTown("ha tay");
        userDto.setDistrict("ha tinh");
        userDto.setCity("ha noi");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        UserType userType = new UserType();
        userType.setName("bac");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_userTypeName_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Le Huu");
        userDto.setLastName("Truong");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2002");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("thach ha");
        userDto.setDistrict("ha tinh");
        userDto.setCity("Ha noi");
        userDto.setCountry("Viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("123456789");
        UserType userType = new UserType();
        userType.setName("");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_userTypeName_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184229992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("thach ha");
        userDto.setDistrict("ha tinh");
        userDto.setCity("ha noi");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12345678");
        UserType userType = new UserType();
        userType.setName("");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_userTypeName_21() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184249992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("ha tinh");
        userDto.setCity("ha noi");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12345678");
        UserType userType = new UserType();
        userType.setName("1###@3@#2#2##@");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_userTypeName_22() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-.1-2020");
        userDto.setIdCard("184249992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("ha tay");
        userDto.setDistrict("ha noi");
        userDto.setCity("ha noi");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12345678");
        UserType userType = new UserType();
        userType.setName("a");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_userTypeName_23() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("Nguyenthanhhai@gmail.com");
        userDto.setPhone("098191360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2020");
        userDto.setIdCard("1842499992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hưng");
        userDto.setTown("ha tay");
        userDto.setDistrict("ha tinh");
        userDto.setCity("ha noi");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12345678");
        UserType userType = new UserType();
        userType.setName("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        List<String> emailList = new ArrayList<>();
        emailList.add("122121");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_emailList_19() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Le Huu");
        userDto.setLastName("Truong");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2002");
        userDto.setIdCard("123456789");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("thach ha");
        userDto.setDistrict("ha tinh");
        userDto.setCity("Ha noi");
        userDto.setCountry("Viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("123456789");
        UserType userType = new UserType();
        userType.setName("truongtruong");
        List<String> emailList = new ArrayList<>();
        emailList.add("");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_emailList_20() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184229992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("thach ha");
        userDto.setDistrict("ha tinh");
        userDto.setCity("ha noi");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12345678");
        UserType userType = new UserType();
        userType.setName("truongtruong");
        List<String> emailList = new ArrayList<>();
        emailList.add("");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
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
    public void updateUser_complete_24() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setFirstName("Lê Hữu");
        userDto.setLastName("Trường");
        userDto.setEmail("nguyenthanhhai@gmail.com");
        userDto.setPhone("0981991360");
        userDto.setPointDedication(12.0);
        userDto.setBirthDay("22-01-2022");
        userDto.setIdCard("184229992");
        userDto.setAvatar("hinh anh");
        userDto.setDetailAddress("117 tran duy hung");
        userDto.setTown("thach ha");
        userDto.setDistrict("ha tinh");
        userDto.setCity("ha noi");
        userDto.setCountry("viet nam");
        userDto.setUsername("HaiNT");
        userDto.setPassword("12345678");
        UserType userType = new UserType();
        userType.setName("truongtruong");
        List<String> emailList = new ArrayList<>();
        emailList.add("TruongLHE");
        userDto.setEmailList(emailList);
        userDto.setUserType(userType);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
