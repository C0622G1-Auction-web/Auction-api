package com.project.dto.user;

import com.project.model.account.Account;
import com.project.model.users.Address;
import com.project.model.users.UserType;

public class UserListDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Address address;
    private UserType userType;
    private Account account;
<<<<<<< HEAD
    private Double pointDedication;
=======
>>>>>>> b529c2b05fbb822ab7b98de68978be70b2e4f8a4

    public UserListDto() {
    }

<<<<<<< HEAD
    public UserListDto(Integer id, String firstName, String lastName, String email, String phone, Address address, UserType userType, Account account, Double pointDedication) {
=======
    public UserListDto(Integer id, String firstName, String lastName, String email, String phone, Address address, UserType userType, Account account) {
>>>>>>> b529c2b05fbb822ab7b98de68978be70b2e4f8a4
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.userType = userType;
        this.account = account;
<<<<<<< HEAD
        this.pointDedication = pointDedication;
=======
>>>>>>> b529c2b05fbb822ab7b98de68978be70b2e4f8a4
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
<<<<<<< HEAD

    public Double getPointDedication() {
        return pointDedication;
    }

    public void setPointDedication(Double pointDedication) {
        this.pointDedication = pointDedication;
    }
=======
>>>>>>> b529c2b05fbb822ab7b98de68978be70b2e4f8a4
}
