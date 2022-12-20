package com.project.model.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Create by: GiangLBH
 * Date created: 18/12/2022
 * Description: Reason to do not review Product
 */
@Entity
public class Reason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId = 0;
    private String reason = "";

    public Reason() {
    }

    public Reason(Integer productId, String reason) {
        this.productId = productId;
        this.reason = reason;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
