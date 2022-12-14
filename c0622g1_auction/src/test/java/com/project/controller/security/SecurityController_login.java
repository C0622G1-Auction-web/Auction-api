package com.project.controller.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.payload.request.LoginForm;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityController_login {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Created by DucDH,
     * Date Created: 14/12/2022
     * Function: to test the validation of field username is null
     *
     * @throws Exception
     */

    @Test
    public void login_username_13() throws Exception {

        LoginForm loginForm = new LoginForm();
        loginForm.setPassword("123");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(loginForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by DucDH,
     * Date Created: 14/12/2022
     * Function: to test the validation of field username is empty
     *
     * @throws Exception
     */

    @Test
    public void login_username_14() throws Exception {

        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("");
        loginForm.setPassword("123");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(loginForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by DucDH,
     * Date Created: 14/12/2022
     * Function: to test the validation of field username is shorter than minlength
     *
     * @throws Exception
     */

    @Test
    public void login_username_16() throws Exception {

        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("12");
        loginForm.setPassword("123");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(loginForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by DucDH,
     * Date Created: 14/12/2022
     * Function: to test the validation of field username is longer than maxlength
     *
     * @throws Exception
     */

    @Test
    public void login_username_17() throws Exception {

        LoginForm loginForm = new LoginForm();
        loginForm.setUsername(
                        "aaaaaaaaaa" +
                        "aaaaaaaaaa" +
                        "aaaaaaaaaa" +
                        "aaaaaaaaaa" +
                        "a");
        loginForm.setPassword("123");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(loginForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by DucDH,
     * Date Created: 14/12/2022
     * Function: to test the validation of field username that doesn't exsit
     *
     * @throws Exception
     */

    @Test
    public void login_username_99() throws Exception {

        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("anUsernameThatDoesntExist");
        loginForm.setPassword("123");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(loginForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by DucDH,
     * Date Created: 14/12/2022
     * Function: to test the validation of field password is null
     *
     * @throws Exception
     */

    @Test
    public void login_password_13() throws Exception {

        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("duc");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(loginForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by DucDH,
     * Date Created: 14/12/2022
     * Function: to test the validation of field password is empty
     *
     * @throws Exception
     */

    @Test
    public void login_password_14() throws Exception {

        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("duc");
        loginForm.setPassword("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(loginForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by DucDH,
     * Date Created: 14/12/2022
     * Function: to test the validation of field password is shorter than minlength
     *
     * @throws Exception
     */

    @Test
    public void login_password_16() throws Exception {

        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("duc");
        loginForm.setPassword("123");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(loginForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by DucDH,
     * Date Created: 14/12/2022
     * Function: to test the validation of field password is longer than maxlength
     *
     * @throws Exception
     */

    @Test
    public void login_password_17() throws Exception {

        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("duc");
        loginForm.setPassword(
                "aaaaaaaaaa" +
                "aaaaaaaaaa" +
                "aaaaaaaaaa" +
                "aaaaaaaaaa" +
                "a");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(loginForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by DucDH,
     * Date Created: 14/12/2022
     * Function: to test the validation of field password that doesn't exist
     *
     * @throws Exception
     */

    @Test
    public void login_password_98() throws Exception {

        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("duc");
        loginForm.setPassword("aPasswordThatDoesntExist");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(loginForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by DucDH,
     * Date Created: 14/12/2022
     * Function: this function use to create medicine with all valid item
     *
     * @throws Exception
     */

    @Test
    public void login_all_item_18() throws Exception {

        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("duc");
        loginForm.setPassword("iuNhi");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(this.objectMapper.writeValueAsString(loginForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

}
