package com.project.controllor;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dto.user.AccountDto;
import com.project.dto.user.AddressDto;
import com.project.dto.user.AddUserDto;
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setLastName("Nam");
        addUserDto.setPointDedication(10.0);
        addUserDto.setAvatar("viet");
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setPhone("123456789");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("");
        addUserDto.setLastName("Nam");
        addUserDto.setPointDedication(10.0);
        addUserDto.setAvatar("viet");
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setPhone("123456789");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("vietaaasa");
        addUserDto.setLastName("Nam");
        addUserDto.setPointDedication(10.0);
        addUserDto.setAvatar("viet");
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setPhone("123456789");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("vietaaasxxxxxxxxxxxxa");
        addUserDto.setLastName("Nam");
        addUserDto.setPointDedication(10.0);
        addUserDto.setAvatar("viet");
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setPhone("123456789");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("v");
        addUserDto.setLastName("Nam");
        addUserDto.setPointDedication(10.0);
        addUserDto.setAvatar("viet");
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setPhone("123456789");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setAvatar("viet");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setPhone("123456789");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("Viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setAvatar("viet");
        addUserDto.setEmail("");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setPhone("123456789");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("Namasasasas");
        addUserDto.setPointDedication(10.0);
        addUserDto.setAvatar("viet");
        addUserDto.setEmail("agmailcom");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setPhone("123456789");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setAvatar("viet");
        addUserDto.setEmail("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setPhone("123456789");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("Viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setAvatar("viet");
        addUserDto.setEmail("@gmail.com");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setPhone("123456789");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setAvatar("viet");
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setAvatar("viet");
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setPhone("");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("Namasasasas");
        addUserDto.setPointDedication(10.0);
        addUserDto.setAvatar("viet");
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setPhone("dadaaw222");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setAvatar("viet");
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setPhone("1234567894444444444444444444444444444444444444");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setAvatar("viet");
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setPhone("1");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setAvatar("");
        addUserDto.setPointDedication(10.0);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setAvatar("1231e121");
        addUserDto.setPointDedication(10.0);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setAvatar("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setAvatar("a");
        addUserDto.setPointDedication(10.0);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setIdCard("1234");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setAvatar("viet");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setAvatar("viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setIdCard("");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setAvatar("viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setIdCard("qqqqqqqqqqqqqqqq");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setAvatar("viet");
        addUserDto.setIdCard("1234888888888888888888888888888888");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setAvatar("viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setIdCard("1");
        addUserDto.setBirthDay("12/12/2021");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setAvatar("viet");
        addUserDto.setIdCard("12345678");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setAvatar("viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setIdCard("12345678");
        addUserDto.setBirthDay("");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setAvatar("viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setIdCard("12345678");
        addUserDto.setBirthDay("adadadadadadada");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setAvatar("viet");
        addUserDto.setIdCard("12345678");
        addUserDto.setBirthDay("121/112/22021");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setAvatar("viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setIdCard("12345678");
        addUserDto.setBirthDay("1/1/202");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setAvatar("viet");
        addUserDto.setIdCard("12345678");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setAvatar("viet");
        addUserDto.setPointDedication(0.0);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setIdCard("12345678");
        addUserDto.setBirthDay("12/12/2022");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setAvatar("viet");
        addUserDto.setPointDedication(010.00);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setIdCard("12345678");
        addUserDto.setBirthDay("12/12/1022");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setPointDedication(100000000000000000000.0);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setAvatar("viet");
        addUserDto.setIdCard("12345678");
        addUserDto.setBirthDay("12/12/2202");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setAvatar("viet");
        addUserDto.setPointDedication(0.1);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setIdCard("12345678");
        addUserDto.setBirthDay("11/11/2022");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setPointDedication(10.0);
        addUserDto.setLastName("viet");
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setAvatar("viet");
        addUserDto.setIdCard("12345678");
        addUserDto.setAccountDto(accountDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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
        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setPointDedication(10.0);
        addUserDto.setLastName("viet");
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setAvatar("viet");
        addUserDto.setIdCard("12345678");
        addUserDto.setAddressDto(addressDto);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
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

        AddUserDto addUserDto = new AddUserDto(formAddUser.getDistrict(), formAddUser.getTown(), formAddUser.getDistrict(), formAddUser.getCity(), formAddUser.getCountry());
        AddressDto addressDto = new AddressDto();
        AccountDto accountDto = new AccountDto();
        addUserDto.setFirstName("Nguyen");
        addUserDto.setLastName("viet");
        addUserDto.setPointDedication(10.0);
        addUserDto.setEmail("a@gmail.com");
        addUserDto.setPhone("123456789");
        addUserDto.setAvatar("viet");
        addUserDto.setIdCard("12345678");
        addUserDto.setBirthDay("12/12/2202");
        addUserDto.setAccountDto(accountDto);
        addUserDto.setAddressDto(addressDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/studentRest/create")
                        .content(this.objectMapper.writeValueAsString(addUserDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
