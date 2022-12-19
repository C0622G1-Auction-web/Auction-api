package com.project.dto.product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;




import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



public class ImgUrlProductDto implements Validator {

    private Integer id;
    @NotBlank
    @NotNull
    private String url;
    @NotBlank
    private Integer product;

    public ImgUrlProductDto() {
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

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
