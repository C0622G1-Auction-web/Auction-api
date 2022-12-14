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

    }
}
