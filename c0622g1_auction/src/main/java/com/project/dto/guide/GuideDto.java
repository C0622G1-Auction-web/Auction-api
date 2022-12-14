package com.project.dto.guide;

import com.project.model.guide.ImgUrlGuide;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class GuideDto implements Validator {
    private Integer id;

    @NotNull(message = "input title not null")
    @NotBlank(message = "Please input title of guide")
    private String title;

    @NotNull(message = "input content not null")
    @NotBlank(message = "Please input content of guide")
    private String content;

    @NotNull(message = "select image not null")

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

public class GuideDto {
    private Integer id;
    @NotBlank(message = "Không được để trống tên chủ đề")
    @Size(min = 10, max=30, message = "Tên chủ đề quá dài hoặc quá ngắn")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message ="Vui lòng nhập đúng định dạng" )
    private String title;
    @NotBlank(message = "Không được để trống nội dung")
    @Size(min=10,max=300 , message ="Nội dung quá độ dài quy định")
    private String content;
    private Boolean deleteStatus;
    private Set<ImgUrlGuide> images;

    public GuideDto() {
    }

    public GuideDto(Integer id, String title, String content, Set<ImgUrlGuide> images) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.images = images;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Set<ImgUrlGuide> getImages() {
        return images;
    }

    public void setImages(Set<ImgUrlGuide> images) {
        this.images = images;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {


    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Set<ImgUrlGuide> getImages() {
        return images;
    }

    public void setImages(Set<ImgUrlGuide> images) {
        this.images = images;

    }
}
