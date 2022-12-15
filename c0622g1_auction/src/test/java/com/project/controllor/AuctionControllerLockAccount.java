package com.project.controllor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.dto.user.AccountDto;
import com.project.dto.user.LockAccountDto;
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
public class AuctionControllerLockAccount {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field startDay more specific is NULL
     */

    @Test
    public void lock_account_startDay_19() throws Exception {
        LockAccountDto lockAccountDto = new LockAccountDto();
        lockAccountDto.setEndDay("12/12/2022");
        lockAccountDto.setReason("nghich ngom");
        lockAccountDto.setAccountDto(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/lockaccount")
                        .content(this.objectMapper.writeValueAsString(lockAccountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field startDay more specific is ("")
     */

    @Test
    public void lock_account_startDay_20() throws Exception {
        LockAccountDto lockAccountDto = new LockAccountDto();
        lockAccountDto.setStartDay("");
        lockAccountDto.setEndDay("12/12/2022");
        lockAccountDto.setReason("nghich ngom");
        lockAccountDto.setAccountDto(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/lockaccount")
                        .content(this.objectMapper.writeValueAsString(lockAccountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field startDay more specific is FORMAT
     */

    @Test
    public void lock_account_startDay_21() throws Exception {
        LockAccountDto lockAccountDto = new LockAccountDto();
        lockAccountDto.setStartDay("qwqwqweqeqeqe");
        lockAccountDto.setEndDay("12/12/2022");
        lockAccountDto.setReason("nghich ngom");
        lockAccountDto.setAccountDto(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/lockaccount")
                        .content(this.objectMapper.writeValueAsString(lockAccountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field endDay more specific is NULL
     */

    @Test
    public void lock_account_endDay_19() throws Exception {
        LockAccountDto lockAccountDto = new LockAccountDto();
        lockAccountDto.setStartDay("12/12/2022");
        lockAccountDto.setReason("nghich ngom");
        lockAccountDto.setAccountDto(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/lockaccount")
                        .content(this.objectMapper.writeValueAsString(lockAccountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field endDay more specific is ("")
     */

    @Test
    public void lock_account_endDay_20() throws Exception {
        LockAccountDto lockAccountDto = new LockAccountDto();
        lockAccountDto.setEndDay("");
        lockAccountDto.setStartDay("12/12/2022");
        lockAccountDto.setReason("nghich ngom");
        lockAccountDto.setAccountDto(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/lockaccount")
                        .content(this.objectMapper.writeValueAsString(lockAccountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field startDay more specific is FORMAT
     */

    @Test
    public void lock_account_endDay_21() throws Exception {
        LockAccountDto lockAccountDto = new LockAccountDto();
        lockAccountDto.setEndDay("qwqwqweqeqeqe");
        lockAccountDto.setStartDay("12/12/2022");
        lockAccountDto.setReason("nghich ngom");
        lockAccountDto.setAccountDto(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/lockaccount")
                        .content(this.objectMapper.writeValueAsString(lockAccountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field reason more specific is NULL
     */

    @Test
    public void lock_account_reason_19() throws Exception {
        LockAccountDto lockAccountDto = new LockAccountDto();
        lockAccountDto.setStartDay("12/12/2022");
        lockAccountDto.setEndDay("15/12/2022");
        lockAccountDto.setAccountDto(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/lockaccount")
                        .content(this.objectMapper.writeValueAsString(lockAccountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field reason more specific is ("")
     */

    @Test
    public void lock_account_reaSon_20() throws Exception {
        LockAccountDto lockAccountDto = new LockAccountDto();
        lockAccountDto.setEndDay("15/12/2022");
        lockAccountDto.setStartDay("12/12/2022");
        lockAccountDto.setReason("");
        lockAccountDto.setAccountDto(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/lockaccount")
                        .content(this.objectMapper.writeValueAsString(lockAccountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field reason more specific is FORMAT
     */
    @Test
    public void lock_account_reason_21() throws Exception {
        LockAccountDto lockAccountDto = new LockAccountDto();
        lockAccountDto.setEndDay("15/12/2022");
        lockAccountDto.setStartDay("12/12/2022");
        lockAccountDto.setReason("11111111111111111111");
        lockAccountDto.setAccountDto(1);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/lockaccount")
                        .content(this.objectMapper.writeValueAsString(lockAccountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation of field AccountDto more specific is null
     */
    @Test
    public void lock_account_AccountDto_19() throws Exception {
        LockAccountDto lockAccountDto = new LockAccountDto();
        lockAccountDto.setEndDay("15/12/2022");
        lockAccountDto.setStartDay("12/12/2022");
        lockAccountDto.setReason("Ngich ngom");
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/user/v1/lockaccount")
                        .content(this.objectMapper.writeValueAsString(lockAccountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: VietNQ
     * Date created: 14/12/2022
     * Function: this function use to test the validation all field ok
     */

    @Test
    public void lock_account_AccountDto_18() throws Exception {
        LockAccountDto lockAccountDto = new LockAccountDto();
        lockAccountDto.setEndDay("15/12/2022");
        lockAccountDto.setStartDay("12/12/2022");
        lockAccountDto.setReason("ngich ngom");
        lockAccountDto.setAccountDto(1);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/user/v1/lockaccount")
                        .content(this.objectMapper.writeValueAsString(lockAccountDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
