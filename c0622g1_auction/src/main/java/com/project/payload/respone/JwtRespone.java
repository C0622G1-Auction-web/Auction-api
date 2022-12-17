package com.project.payload.respone;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtRespone {

    private Integer id;
    private String token;
    private String username;
    private Collection<? extends GrantedAuthority> roles;
    private Integer accountId;
    private Boolean statusLock;
    private Boolean deleteStauts;

    public JwtRespone() {
    }

    public JwtRespone(String token, String username, Collection<? extends GrantedAuthority> roles,
                      Integer accountId, Boolean statusLock, Boolean deleteStauts) {
        this.token = token;
        this.username = username;
        this.roles = roles;
        this.accountId = accountId;
        this.statusLock = statusLock;
        this.deleteStauts = deleteStauts;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
