package com.project.model.product.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ImgUrlProductDTO {
    private Integer id;
    @NotBlank
    @NotNull
    private String url;


    @NotNull
    private Integer productId;

    public ImgUrlProductDTO() {
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
