package com.project.controllor;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dto.user.AccountDto;
import com.project.dto.user.AddressDto;
import com.project.dto.user.UserDto;
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
public class AuctionControllerAddUser {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field first name more specific is NULL
     */

    @Test
    public void addUser_fisrt_name_13() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setLastName("Nam");
        userDto.setPointDedication(10.0);
        userDto.setAvatar("viet");
        userDto.setEmail("a@gmail.com");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setPhone("123456789");
        userDto.setAccountDto(accountDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field first name more specific is ("")
     */
    @Test
    public void addUser_fisrt_name_14() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("");
        userDto.setLastName("Nam");
        userDto.setPointDedication(10.0);
        userDto.setAvatar("viet");
        userDto.setEmail("a@gmail.com");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setPhone("123456789");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field first name more specific is FORMAT
     */
    @Test
    public void addUser_fisrt_name_15() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("vietaaasa");
        userDto.setLastName("Nam");
        userDto.setPointDedication(10.0);
        userDto.setAvatar("viet");
        userDto.setEmail("a@gmail.com");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setPhone("123456789");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field first name more specific is [item] >= minlength
     */
    @Test
    public void addUser_fisrt_name_16() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("vietaaasxxxxxxxxxxxxa");
        userDto.setLastName("Nam");
        userDto.setPointDedication(10.0);
        userDto.setAvatar("viet");
        userDto.setEmail("a@gmail.com");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setPhone("123456789");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field first name more specific is [item] =< minlength
     */
    @Test
    public void addUser_fisrt_name_17() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("v");
        userDto.setLastName("Nam");
        userDto.setPointDedication(10.0);
        userDto.setAvatar("viet");
        userDto.setEmail("a@gmail.com");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setPhone("123456789");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field gmail  more specific is NULL
     */

    @Test
    public void addUser_gmail_13() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setPointDedication(10.0);
        userDto.setAvatar("viet");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setPhone("123456789");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field gmail more specific is ("")
     */
    @Test
    public void addUser_gmail_14() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("Viet");
        userDto.setPointDedication(10.0);
        userDto.setAvatar("viet");
        userDto.setEmail("");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setPhone("123456789");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field gmail more specific is FORMAT
     */
    @Test
    public void addUser_gmail_15() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("Namasasasas");
        userDto.setPointDedication(10.0);
        userDto.setAvatar("viet");
        userDto.setEmail("agmailcom");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setPhone("123456789");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field gmail more specific is [item] >= minlength
     */
    @Test
    public void addUser_gmail_16() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setPointDedication(10.0);
        userDto.setAvatar("viet");
        userDto.setEmail("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setPhone("123456789");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field gmail more specific is [item] =< minlength
     */
    @Test
    public void addUser_gmail_17() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("Viet");
        userDto.setPointDedication(10.0);
        userDto.setAvatar("viet");
        userDto.setEmail("@gmail.com");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setPhone("123456789");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field phone more specific is NULL
     */

    @Test
    public void addUser_phone_13() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setPointDedication(10.0);
        userDto.setAvatar("viet");
        userDto.setEmail("a@gmail.com");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field phone more specific is ("")
     */
    @Test
    public void addUser_phone_14() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setPointDedication(10.0);
        userDto.setAvatar("viet");
        userDto.setEmail("a@gmail.com");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setPhone("");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field phone more specific is FORMAT
     */
    @Test
    public void addUser_phone_15() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("Namasasasas");
        userDto.setPointDedication(10.0);
        userDto.setAvatar("viet");
        userDto.setEmail("a@gmail.com");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setPhone("dadaaw222");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field phone more specific is [item] >= minlength
     */
    @Test
    public void addUser_phone_16() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setPointDedication(10.0);
        userDto.setAvatar("viet");
        userDto.setEmail("a@gmail.com");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setPhone("1234567894444444444444444444444444444444444444");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field phone more specific is [item] =< minlength
     */
    @Test
    public void addUser_phone_17() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setPointDedication(10.0);
        userDto.setAvatar("viet");
        userDto.setEmail("a@gmail.com");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setPhone("1");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field avatar more specific is NULL
     */

    @Test
    public void addUser_avatar_13() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setPointDedication(10.0);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field avatar more specific is ("")
     */

    @Test
    public void addUser_avatar_14() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setAvatar("");
        userDto.setPointDedication(10.0);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field avatar more specific is fomart
     */

    @Test
    public void addUser_avatar_15() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setAvatar("1231e121");
        userDto.setPointDedication(10.0);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field avatar more specific is [item] >= minlength
     */

    @Test
    public void addUser_avatar_16() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setPointDedication(10.0);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setAvatar("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field avatar more specific is [item] =< minlength
     */

    @Test
    public void addUser_avatar_17() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setAvatar("a");
        userDto.setPointDedication(10.0);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setIdCard("1234");
        userDto.setBirthDay("12/12/2021");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field idCard more specific is NULL
     */

    @Test
    public void addUser_idCard_13() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setPointDedication(10.0);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setAvatar("viet");
        userDto.setBirthDay("12/12/2021");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field idCard more specific is ("")
     */

    @Test
    public void addUser_idCard_14() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setAvatar("viet");
        userDto.setPointDedication(10.0);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setIdCard("");
        userDto.setBirthDay("12/12/2021");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field idCard more specific is fomart
     */

    @Test
    public void addUser_idCard_15() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setAvatar("viet");
        userDto.setPointDedication(10.0);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setIdCard("qqqqqqqqqqqqqqqq");
        userDto.setBirthDay("12/12/2021");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field idCard more specific is [item] >= minlength
     */

    @Test
    public void addUser_idCard_16() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setPointDedication(10.0);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setAvatar("viet");
        userDto.setIdCard("1234888888888888888888888888888888");
        userDto.setBirthDay("12/12/2021");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field idCard more specific is [item] =< minlength
     */

    @Test
    public void addUser_idCard_17() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setAvatar("viet");
        userDto.setPointDedication(10.0);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setIdCard("1");
        userDto.setBirthDay("12/12/2021");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field birthday more specific is NULL
     */

    @Test
    public void addUser_birthDay_13() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setPointDedication(10.0);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setAvatar("viet");
        userDto.setIdCard("12345678");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field birthday more specific is ("")
     */

    @Test
    public void addUser_birthDay_14() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setAvatar("viet");
        userDto.setPointDedication(10.0);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setIdCard("12345678");
        userDto.setBirthDay("");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field birthday more specific is fomart
     */

    @Test
    public void addUser_birthday_15() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setAvatar("viet");
        userDto.setPointDedication(10.0);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setIdCard("12345678");
        userDto.setBirthDay("adadadadadadada");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field birthday more specific is [item] >= minlength
     */

    @Test
    public void addUser_birthDay_16() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setPointDedication(10.0);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setAvatar("viet");
        userDto.setIdCard("12345678");
        userDto.setBirthDay("121/112/22021");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field birthday more specific is [item] =< minlength
     */

    @Test
    public void addUser_birthDay_17() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setAvatar("viet");
        userDto.setPointDedication(10.0);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setIdCard("12345678");
        userDto.setBirthDay("1/1/202");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field PointDedication more specific is NULL
     */

    @Test
    public void addUser_pointDedication_13() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setAvatar("viet");
        userDto.setIdCard("12345678");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field PointDedication more specific is ("")
     */

    @Test
    public void addUser_pointDedication_14() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setAvatar("viet");
        userDto.setPointDedication(0.0);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setIdCard("12345678");
        userDto.setBirthDay("12/12/2022");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field pointDedication specific is fomart
     */

    @Test
    public void addUser_pointDedication_15() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setAvatar("viet");
        userDto.setPointDedication(010.00);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setIdCard("12345678");
        userDto.setBirthDay("12/12/1022");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field PointDedication more specific is [item] >= minlength
     */

    @Test
    public void addUser_pointDedication_16() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setPointDedication(100000000000000000000.0);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setAvatar("viet");
        userDto.setIdCard("12345678");
        userDto.setBirthDay("12/12/2202");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field PointDedication more specific is [item] =< minlength
     */

    @Test
    public void addUser_pointDedication_17() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setAvatar("viet");
        userDto.setPointDedication(0.1);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setIdCard("12345678");
        userDto.setBirthDay("11/11/2022");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field AdressDto more specific is NULL
     */

    @Test
    public void addUser_AdressDto_13() throws Exception {
        UserDto userDto = new UserDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setPointDedication(10.0);
        userDto.setLastName("viet");
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setAvatar("viet");
        userDto.setIdCard("12345678");
        userDto.setAccountDto(accountDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field AccountDto more specific is NULL
     */

    @Test
    public void addUser_accountDto_13() throws Exception {
        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        userDto.setFirstName("Nguyen");
        userDto.setPointDedication(10.0);
        userDto.setLastName("viet");
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setAvatar("viet");
        userDto.setIdCard("12345678");
        userDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of all field ok
     */
    @Test
    public void createStudent_18() throws Exception {

        UserDto userDto = new UserDto();
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        userDto.setFirstName("Nguyen");
        userDto.setLastName("viet");
        userDto.setPointDedication(10.0);
        userDto.setEmail("a@gmail.com");
        userDto.setPhone("123456789");
        userDto.setAvatar("viet");
        userDto.setIdCard("12345678");
        userDto.setBirthDay("12/12/2202");
        userDto.setAccountDto(accountDto);
        userDto.setAddressDto(addressDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/studentRest/create")
                        .content(this.objectMapper.writeValueAsString(userDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
