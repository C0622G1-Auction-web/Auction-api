package com.project.dto.guide;

import com.project.model.guide.Guide;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ImgUrlGuideDto implements Validator {
    private Integer id;

    @NotNull(message = "input url of image guide not null")
    @NotBlank(message = "Please input url of image guide")
    private String url;

    @NotNull(message = "input guide not null")
    private GuideDto guideDto;

    public ImgUrlGuideDto() {
    }

    public ImgUrlGuideDto(Integer id, String url, GuideDto guideDto) {
        this.id = id;
        this.url = url;
        this.guideDto = guideDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public GuideDto getGuide() {
        return guideDto;
    }

    public void setGuide(GuideDto guideDto) {
        this.guideDto = guideDto;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
