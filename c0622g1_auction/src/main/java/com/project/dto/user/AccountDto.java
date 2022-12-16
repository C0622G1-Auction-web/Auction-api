package com.project.dto.user;

public class AccountDto {
    private int id;
    private String username;
    private String password;
    private Boolean statusLock;
    private Boolean deleteStatus;


    public AccountDto(String username, String password, Boolean statusLock , Boolean deleteStatus) {
        this.username = username;
        this.password = password;
        this.statusLock = statusLock;
        this.deleteStatus = deleteStatus;
    }

    public Boolean getStatusLock() {
        return statusLock;
    }

    public void setStatusLock(Boolean statusLock) {
        this.statusLock = statusLock;
    }

    public AccountDto() {
    }

    public AccountDto(String username) {
        this.username = username;
    }


    public AccountDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

<<<<<<< HEAD
=======

>>>>>>> b529c2b05fbb822ab7b98de68978be70b2e4f8a4
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
    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

}
