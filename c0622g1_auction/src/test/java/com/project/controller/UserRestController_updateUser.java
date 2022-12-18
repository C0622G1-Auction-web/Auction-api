package com.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dto.user.UserListDto;
import com.project.model.account.Account;
import com.project.model.users.Address;
import com.project.model.users.UserType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserRestController_updateUser {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field fist name more specific is null
     */
    @Test
    public void test_updateUser_fist_name_21() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field Last name more specific is null
     */
    @Test
    public void test_updateUser_Last_name_21() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field Email more specific is null
     */
    @Test
    public void test_updateUser_Email_21() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field Phone more specific is null
     */
    @Test
    public void test_updateUser_Phone_21() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field AccountId more specific is null
     */
    @Test
    public void test_updateUser_Account_21() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(null);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field address_Id more specific is null
     */
    @Test
    public void test_updateUser_address_21() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(null);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field userType_Id more specific is null
     */
    @Test
    public void test_updateUser_userType_21() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(null);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field fist name more specific is containing special character
     */
    @Test
    public void test_updateUser_fist_name_22() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field Last name more specific is empty
     */
    @Test
    public void test_updateUser_Last_name_22() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field Email more specific is empty
     */
    @Test
    public void test_updateUser_Email_22() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field Phone more specific is empty
     */
    @Test
    public void test_updateUser_Phone_22() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field AccountId more specific is empty
     */
    @Test
    public void test_updateUser_Account_22() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(null);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field address_Id more specific is empty
     */
    @Test
    public void test_updateUser_address_22() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(null);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field userType_Id more specific is empty
     */
    @Test
    public void test_updateUser_userType_22() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(null);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field fist name more specific is containing special character
     */
    @Test
    public void test_updateUser_fist_name_23() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("sdfg244");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field Last name more specific is containing special character
     */
    @Test
    public void test_updateUser_Last_name_23() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("xdxgsg452475");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field Email more specific is containing special character
     */
    @Test
    public void test_updateUser_Email_23() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("xdvs345345");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field Phone more specific is containing special character
     */
    @Test
    public void test_updateUser_Phone_23() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("sdafsdf4534");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field AccountId more specific is containing special character
     */
    @Test
    public void test_updateUser_Account_23() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(null);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field address_Id more specific is containing special character
     */
    @Test
    public void test_updateUser_address_23() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(null);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field userType_Id more specific is containing special character
     */
    @Test
    public void test_updateUser_userType_23() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(null);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field fist name more specific is minlength
     */
    @Test
    public void test_updateUser_fist_name_24() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("sdfg244ddddddddddddddddddddddddddddddddddd");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field Last name more specific is minlength
     */
    @Test
    public void test_updateUser_Last_name_24() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("xdxgsg452475fffffffffffffffffffffffffff");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field Email more specific is   minlength
     */
    @Test
    public void test_updateUser_Email_24() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("xdvs345345sssssssssssssssssssssssssssssss");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field Phone more specific is minlength
     */
    @Test
    public void test_updateUser_Phone_24() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("sdafsdf45343333333333333333333");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field AccountId more specific is minlength
     */
    @Test
    public void test_updateUser_Account_24() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(null);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field address_Id more specific is minlength
     */
    @Test
    public void test_updateUser_address_24() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(null);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field userType_Id more specific is minlength
     */
    @Test
    public void test_updateUser_userType_24() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(null);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field fist name more specific is maxlength
     */
    @Test
    public void test_updateUser_fist_name_25() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("sdfg244ddddddddddddddddddddddddddddddddddd");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field Last name more specific is maxlength
     */
    @Test
    public void test_updateUser_Last_name_25() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("xdxgsg452475fffffffffffffffffffffffffff");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field Email more specific is   maxlength
     */
    @Test
    public void test_updateUser_Email_25() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("xdvs345345sssssssssssssssssssssssssssssss");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field Phone more specific is maxlength
     */
    @Test
    public void test_updateUser_Phone_25() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("sdafsdf45343333333333333333333");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field AccountId more specific is maxlength
     */
    @Test
    public void test_updateUser_Account_25() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(null);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field address_Id more specific is maxlength
     */
    @Test
    public void test_updateUser_address_25() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(null);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field userType_Id more specific is maxlength
     */
    @Test
    public void test_updateUser_userType_25() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(null);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HaiNT
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field fist name more specific is successful
     */
    @Test
    public void test_updateUser_fist_name_26() throws Exception {
        UserListDto userListDto = new UserListDto();
        Address address = new Address();
        Account account = new Account();
        UserType userType = new UserType();
        userListDto.setFirstName("Nguyễn");
        userListDto.setLastName("Thanh Hải");
        userListDto.setEmail("a@gmail.com");
        userListDto.setPhone("092452345126");
        account.setId(1);
        address.setId(1);
        userType.setId(1);
        userListDto.setAccount(account);
        userListDto.setUserType(userType);
        userListDto.setAddress(address);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/api/user/1")
                .content(this.objectMapper.writeValueAsString(userListDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }



}
