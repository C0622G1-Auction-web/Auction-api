package com.project.model.users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.project.model.account.Account;
import com.project.model.auction.Auction;
import com.project.model.product.Product;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Double pointDedication;
    private String birthDay;
    private String idCard;
    private String avatar;
    @Column(columnDefinition = "boolean default true")
    private Boolean deleteStatus;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    @JsonBackReference
    private Address address;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_type_id",referencedColumnName = "id")
    @JsonBackReference
    private UserType userType;
    @OneToMany(mappedBy="user")
    @JsonBackReference

    @JsonIgnore

    private Set<Auction> auctions;
    @OneToOne
    @JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    @JsonBackReference
    private Account account1;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private Set<Product> products;

    public User() {
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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
