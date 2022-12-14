package com.project.dto.product;

import com.project.dto.user.UserDto;
import com.project.model.users.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDto implements Validator {
    private int id;

    @NotNull(message = "Name of product not null")
    @NotBlank(message = "Please input Name of Product")
    private String name;

    @NotNull(message = "Description of product not null")
    @NotBlank(message = "Please input Description of Product")
    private String description;

    @NotNull(message = "Initial Price of product not null")
    @NotBlank(message = "Please input initial Price of Product")
    private Double initialPrice;

    @NotNull(message = "Start Time of product not null")
    @NotBlank(message = "Please input start time to auction Product")
    private String startTime;

    @NotNull(message = "End Time of product not null")
    @NotBlank(message = "Please input end time to auction Product")
    private String endTime;

    @NotBlank(message = "Please input step price to auction Product")
    private PriceStepDto priceStepDto;

    @NotBlank(message = "Please select options category to auction Product")
    private CategoryDto categoryDto;

    private UserDto userDto;

    public ProductDto() {
    }

    public ProductDto(int id, String name, String description, Double initialPrice, String startTime, String endTime, PriceStepDto priceStepDto, CategoryDto categoryDto, UserDto userDto) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.initialPrice = initialPrice;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priceStepDto = priceStepDto;
        this.categoryDto = categoryDto;
        this.userDto = userDto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(Double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public PriceStepDto getPriceStep() {
        return priceStepDto;
    }

    public void setPriceStep(PriceStepDto priceStepDto) {
        this.priceStepDto = priceStepDto;
    }

    public CategoryDto getCategory() {
        return categoryDto;
    }

    public void setCategory(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public UserDto getUser() {
        return userDto;
    }

    public void setUser(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;

        if (!productDto.name.matches("[A-Za-z ]+")) {
            errors.rejectValue("name", "name.invalidFormat");
        }
    }
}
