package com.project.dto.user;

import com.project.dto.product.ProductDto;
import com.project.model.account.Account;
import com.project.model.auction.Auction;
import com.project.model.product.Product;
import com.project.model.users.Address;
import com.project.model.users.UserType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Set;

public class UserDto implements Validator {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Double pointDedication;
    private String birthDay;
    private String idCard;
    private String avatar;

    private Boolean deleteStatus;

    private Address address;

    private UserType userType;

    private Set<Auction> auctions;

    private Account account;

    private Set<ProductDto> productDtos;

    public UserDto() {
    }

    public UserDto(Integer id, String firstName, String lastName, String email, String phone, Double pointDedication, String birthDay, String idCard, String avatar, Boolean deleteStatus, Address address, UserType userType, Set<Auction> auctions, Account account, Set<ProductDto> productDtos) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.pointDedication = pointDedication;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.avatar = avatar;
        this.deleteStatus = deleteStatus;
        this.address = address;
        this.userType = userType;
        this.auctions = auctions;
        this.account = account;
        this.productDtos = productDtos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getPointDedication() {
        return pointDedication;
    }

    public void setPointDedication(Double pointDedication) {
        this.pointDedication = pointDedication;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Set<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(Set<Auction> auctions) {
        this.auctions = auctions;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<ProductDto> getProductDtos() {
        return productDtos;
    }

    public void setProductDtos(Set<ProductDto> productDtos) {
        this.productDtos = productDtos;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
