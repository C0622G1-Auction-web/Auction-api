package com.project.model.product.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.model.product.Product;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ImgUrlProductDTO {
    private Integer id;
    private String url;
    private Integer product_id;

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

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
}
