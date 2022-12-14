package com.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GuideRestController_getGuideList {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListGuide_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("auction/api/guide"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListStudent_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("auction/api/guide"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].title").value("Cách đăng ký account"))
                .andExpect(jsonPath("content[0].content").value("Bước 1: Bạn vào trang chủ của sàn đấu giá. Trên thanh menu tìm kiếm, chọn mục đăng ký tài khoản.\n" +
                        "Bước 2: Sau khi vào form đăng ký tài khoản bạn nhập đúng nội dung form yêu cầu.\n" +
                        "Bước 3: Sau khi bạn nhập nội dung đúng với yêu cầu của sàn đấu giá, bấm xác nhận và đợi một lát nhé ! Tài khoản của bạn sẽ được tạo trong chốc lát\n" +
                        "Nếu bạn đã tạo account thành công, xin chúc mừng đã đến với sàn đấu giá của chúng tôi. Hi vọng bạn sẽ có sân chơi đấu giá vui vẻ !"))
                .andExpect(jsonPath("content[0].images.id").value(1))
                .andExpect(jsonPath("content[0].images.id").value(2))
                .andExpect(jsonPath("content[4].title").value("Cách thức đấu giá"))
                .andExpect(jsonPath("content[4].content").value("Bước 1: Bạn vào hồ sơ cá nhân của mình rồi chọn mục mật khẩu\n" +
                        "Bước 2: Sau khi vào mục mật khẩu, bạn sẽ nhập lại mật khẩu cũ trước đó. Sau đó bạn nhập mật khẩu mới mong muốn cập nhật, sau đó xác nhận lại mât khẩu mới mà bạn vừa nhâp ở trên\n" +
                        "Bước 3: Nếu mật khẩu mới và xác nhận mật khẩu mới trùng khớp. Thì bạn đã cập nhật mật khẩu mới thành công. Nếu quên mật khẩu cũ thì bạn hãy xem hướng dẫn mục 3 nhé !\n" +
                        "Chúc bạn có một sân chơi đấu giá thành công và vui vẻ !\n"))
                .andExpect(jsonPath("content[4].images.id").value(7))
                .andExpect(jsonPath("content[4].images.id").value(8));
    }
}
