package com.project.userCreateUpdate;

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
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_firstName_20() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/1/update")
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
    public void updateUser_firstName_21() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_firstName_22() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_firstName_23() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_lastName_19() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_lastName_20() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_lastName_21() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_lastName_22() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_lastName_23() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_email_19() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_email_20() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_email_21() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_email_22() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_email_23() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_phone_19() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
    public void updateUser_phone_20() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_phone_21() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_phone_22() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_phone_23() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_pointDedication_19() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_pointDedication_20() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_pointDedication_21() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_pointDedication_22() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_birthDay_19() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_birthDay_20() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_birthDay_21() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_birthDay_22() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_birthDay_23() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_idCard_19() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_idCard_20() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_idCard_21() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_idCard_22() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_idCard_23() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_avatar_19() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_avatar_20() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_avatar_21() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_avatar_22() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_avatar_23() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_detailAddress_19() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_detailAddress_20() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_detailAddress_21() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_detailAddress_22() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_detailAddress_23() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_town_19() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_town_20() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_town_21() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_town_22() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_town_23() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_district_19() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_district_20() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_district_21() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_district_22() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_district_23() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_city_19() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_city_20() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_city_21() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_city_22() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_city_23() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_country_19() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_country_20() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_country_21() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_country_22() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_country_23() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
    public void updateUser_username_19() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_username_20() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_username_21() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
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
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_username_22() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_username_23() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_password_19() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_password_20() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_password_21() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_password_22() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_password_23() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_userTypeName_19() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_userTypeName_20() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_userTypeName_21() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_userTypeName_22() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_userTypeName_23() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_emailList_19() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
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
    public void updateUser_emailList_20() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
    public void updateUser_complete_24() throws Exception {
        UserDto userCreateUpdateDto = new UserDto();
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
                        .post("/api/user/v1/1/update")
                        .content(this.objectMapper.writeValueAsString(userCreateUpdateDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
