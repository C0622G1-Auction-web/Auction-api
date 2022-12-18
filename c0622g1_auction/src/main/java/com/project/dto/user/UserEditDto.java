package com.project.dto.user;

import com.project.model.account.Account;
import com.project.model.users.Address;
import com.project.model.users.UserType;

public class UserEditDto {
    private String firstName;
    private String lastName;
    private String username;
    private String birthDay;
    private String idCard;
    private String phone;
    private String email;
    private String city;
    private String district;
    private String town;
    private String detailAddress;

    public UserEditDto() {
    }

    public UserEditDto(String firstName, String lastName, String username, String birthDay, String idCard, String phone, String email, String city, String district, String town, String detailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.district = district;
        this.town = town;
        this.detailAddress = detailAddress;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }
}
