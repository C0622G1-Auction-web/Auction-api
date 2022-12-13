package com.project.model.account;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PasswordResetToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String token;
    LocalDateTime expiryDate;
    @Column (columnDefinition = "default 0")
    boolean status;
    @ManyToOne()
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    public PasswordResetToken() {
    }

    public PasswordResetToken(Integer id, String token, LocalDateTime expiryDate, boolean status, Account account) {
        this.id = id;
        this.token = token;
        this.expiryDate = expiryDate;
        this.status = status;
        this.account = account;
    }

    public PasswordResetToken(String token, LocalDateTime expiryDate, boolean status, Account account) {
        this.token = token;
        this.expiryDate = expiryDate;
        this.status = status;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
