package com.project.model.auction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.model.payment.Payment;
import com.project.model.product.Product;
import com.project.model.users.User;

import javax.persistence.*;

@Entity
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double currentPrice;
    private String auctionTime;
    private Boolean payStatus;
    @Column(columnDefinition = "boolean default false")
    private Boolean auctionStatus;
    @Column(columnDefinition = "boolean default false")
    private Boolean deleteStatus;

    private String auctionDay;



    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    @JsonBackReference
    private User user;


    @JsonBackReference
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;


    @JsonBackReference
    @OneToOne(mappedBy = "auction")
    private Payment payment;
    public Auction() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(String auctionTime) {
        this.auctionTime = auctionTime;
    }

    public Boolean getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Boolean payStatus) {
        this.payStatus = payStatus;
    }

    public Boolean getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(Boolean auctionStatus) {
        this.auctionStatus = auctionStatus;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getAuctionDay() {
        return auctionDay;
    }

    public void setAuctionDay(String auctionDay) {
        this.auctionDay = auctionDay;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
