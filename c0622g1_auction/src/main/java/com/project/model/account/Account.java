package com.project.model.account;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.model.users.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    @NotBlank
    @NotEmpty
    @Size(min = 10, max = 30)
    private String password;
    @Column(columnDefinition = "boolean default true")
    private Boolean statusLock;
    @Column(columnDefinition = "boolean default true")
    private Boolean deleteStatus;
    @OneToMany(mappedBy = "account")
    @JsonBackReference
    private Set<AccountRole> accountRoles;
    @OneToMany(mappedBy = "account")
    @JsonBackReference
    private Set<PasswordResetToken> passwordResetTokens;
    @OneToOne(mappedBy = "account")
    @JsonBackReference
    private User user;
    @OneToOne(mappedBy = "account")
    @JsonBackReference
    private LockAccount lockAccount;
    public Account() {
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public LockAccount getLockAccount() {
        return lockAccount;
    }

    public void setLockAccount(LockAccount lockAccount) {
        this.lockAccount = lockAccount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatusLock() {
        return statusLock;
    }

    public void setStatusLock(Boolean statusLock) {
        this.statusLock = statusLock;
    }

    public Set<AccountRole> getAccountRoles() {
        return accountRoles;
    }

    public void setAccountRoles(Set<AccountRole> accountRoles) {
        this.accountRoles = accountRoles;
    }

    public Set<PasswordResetToken> getPasswordResetTokens() {
        return passwordResetTokens;
    }

    public void setPasswordResetTokens(Set<PasswordResetToken> passwordResetTokens) {
        this.passwordResetTokens = passwordResetTokens;
    }
}
