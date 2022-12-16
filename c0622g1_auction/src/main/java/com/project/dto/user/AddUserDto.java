package com.project.dto.user;


import com.project.model.users.UserType;


public class AddUserDto {
    public AddUserDto() {
    }

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
    private AddressDto addressDto;
    private AccountDto accountDto;

    public AddUserDto(String firstName, String lastName, String email, String phone, Double pointDedication, String birthDay, String idCard, String avatar, AddressDto addressDto, AccountDto accountDto) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.pointDedication = pointDedication;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.avatar = avatar;
        this.addressDto = addressDto;
        this.accountDto = accountDto;
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

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public AccountDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountDto accountDto) {
        this.accountDto = accountDto;
    }


}
