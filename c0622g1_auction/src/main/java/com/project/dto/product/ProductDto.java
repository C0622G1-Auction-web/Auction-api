package com.project.dto.product;

import com.project.dto.user.UserDto;
import com.project.model.auction.Auction;
import com.project.model.product.AuctionStatus;
import com.project.model.product.Category;
import com.project.model.product.ImgUrlProduct;
import com.project.model.product.PriceStep;
import com.project.model.users.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class ProductDto implements Validator {
    private int id;
    private String fullName;
    private Double maxCurrentPrice;

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
    private PriceStepDTO priceStepDto;

    @NotBlank(message = "Please select options category to auction Product")
    private CategoryDTO categoryDto;
    private UserDto userDto;
    private Boolean deleteStatus;

    @NotNull(message = "End Time of product not null")
    @NotBlank(message = "Please input end time to auction Product")
    private String registerDay;


    @NotBlank(message = "Please input step price to auction Product")
    private PriceStep priceStep;

    @NotBlank(message = "Please select options category to auction Product")
    private Category category;
    private User user;
    private ReviewStatus reviewStatus;
    private AuctionStatus auctionStatus;
    private Set<ImgUrlProduct> imgUrlProducts;
    private Set<Auction> auctions;

    public ProductDto() {
    }

    public ProductDto(int id, String name, String description, Double initialPrice, String startTime, String endTime, PriceStepDTO priceStepDto, CategoryDTO categoryDto, UserDto userDto) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.initialPrice = initialPrice;
        this.startTime = startTime;
        this.endTime = endTime;
        this.deleteStatus = deleteStatus;
        this.registerDay = registerDay;
        this.priceStep = priceStep;
        this.category = category;
        this.user = user;
        this.reviewStatus = reviewStatus;
        this.auctionStatus = auctionStatus;
        this.imgUrlProducts = imgUrlProducts;
        this.auctions = auctions;
    }

    public ProductDto(String name, String description, Double initialPrice, String startTime, String endTime, Boolean deleteStatus, String registerDay, CategoryDTO categoryDto, PriceStepDTO priceStepDto, UserDto userDto) {
        this.name = name;
        this.description = description;
        this.initialPrice = initialPrice;
        this.startTime = startTime;
        this.endTime = endTime;
        this.deleteStatus = deleteStatus;
        this.registerDay = registerDay;
        this.categoryDto = categoryDto;
        this.priceStepDto = priceStepDto;
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


    public void setPriceStepDto(PriceStepDTO priceStepDto) {
        this.priceStepDto = priceStepDto;
    }

    public void setCategoryDto(CategoryDTO categoryDto) {
        this.categoryDto = categoryDto;
    }

    public void setCategory(CategoryDTO categoryDto) {
        this.categoryDto = categoryDto;
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

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getRegisterDay() {
        return registerDay;
    }

    public void setRegisterDay(String registerDay) {
        this.registerDay = registerDay;
    }

    public PriceStep getPriceStep() {
        return priceStep;
    }

    public void setPriceStep(PriceStep priceStep) {
        this.priceStep = priceStep;
    }

    public ReviewStatus getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(ReviewStatus reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public AuctionStatus getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(AuctionStatus auctionStatus) {
        this.auctionStatus = auctionStatus;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<ImgUrlProduct> getImgUrlProducts() {
        return imgUrlProducts;
    }

    public void setImgUrlProducts(Set<ImgUrlProduct> imgUrlProducts) {
        this.imgUrlProducts = imgUrlProducts;
    }

    public Set<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(Set<Auction> auctions) {
        this.auctions = auctions;
    }

    public User getUser() {
        return user;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public PriceStepDTO getPriceStepDto() {
        return priceStepDto;
    }


    public CategoryDTO getCategoryDto() {
        return categoryDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public Double getMaxCurrentPrice() {
        return maxCurrentPrice;
    }

    public void setMaxCurrentPrice(Double maxCurrentPrice) {
        this.maxCurrentPrice = maxCurrentPrice;
    }
}
