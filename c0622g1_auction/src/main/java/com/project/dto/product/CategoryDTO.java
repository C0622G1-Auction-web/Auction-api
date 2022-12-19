package com.project.dto.product;

import com.project.model.product.Product;

import java.util.Set;

public class CategoryDto {
    private Integer id;
    private String name;
    private Set<Product> products;

    public CategoryDto() {
    }

    public CategoryDto(String name) {
        this.name = name;
    }


    public CategoryDto(int id, String name, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

