package com.project.service.users;


import com.project.model.users.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findUser(int id);
}
