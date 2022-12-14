package com.project.model.product.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.model.product.Product;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ImgUrlProductDTO {
    private Integer id;
    private String url;
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
