package com.project.service.users;


import com.project.model.account.Account;
import com.project.model.users.User;

public interface IUserService {
    User findUserByAccount(Account account);
}
