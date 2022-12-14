package com.project.model.payment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.model.auction.Auction;

import javax.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String shippingDescription;
    private Boolean paymentStatus;
    @Column(columnDefinition = "boolean default true")
    private Boolean deleteStatus;
    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "auction_id",referencedColumnName = "id")
    private Auction auction;

    public Payment() {
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShippingDescription() {
        return shippingDescription;
    }

    public void setShippingDescription(String shippingDescription) {
        this.shippingDescription = shippingDescription;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
