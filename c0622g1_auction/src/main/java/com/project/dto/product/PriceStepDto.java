package com.project.dto.product;

import com.project.model.product.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

public class PriceStepDto implements Validator {

    private Integer id;

    @NotEmpty(message = "please input step price")
    private String step;

    private Set<Product> products;

    public PriceStepDto() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
