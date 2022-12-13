package com.project.service.users;


import com.project.model.users.Address;
import com.project.model.users.User;

public interface IUserService {
    void saveUser(User user);
    void saveAddress(Address address);
}
