package com.project.dto.payment;

public class PaymentDtoGetShip {
    private Integer id;
    private String shippingDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentDtoGetShip() {
    }

    public String getShippingDescription() {
        return shippingDescription;
    }

    public void setShippingDescription(String shippingDescription) {
        this.shippingDescription = shippingDescription;
    }
}
