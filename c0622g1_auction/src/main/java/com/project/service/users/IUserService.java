package com.project.service.users;


import com.project.model.users.User;

import java.util.List;

public interface IUserService {

     List<User> getUserBy(String id, String name, String email, String userTypeId, String address);

     User findById(int id);

}
