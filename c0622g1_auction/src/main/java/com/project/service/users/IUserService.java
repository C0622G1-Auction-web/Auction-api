package com.project.service.users;


import com.project.model.users.User;

public interface IUserService {
    void saveUser(User user, Integer addressId, Integer accountId,Integer Number);
}
