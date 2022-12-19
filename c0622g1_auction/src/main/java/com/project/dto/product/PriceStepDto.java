package com.project.dto.product;

import com.project.model.product.Product;

import java.util.Set;

public class PriceStepDto {
    private Integer id;
    private String step;
    private Set<Product> products;

    public PriceStepDto() {
    }

    public PriceStepDto(String step) {
        this.step = step;
    }

    public PriceStepDto(Integer id, String step, Set<Product> products) {
        this.id = id;
        this.step = step;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

