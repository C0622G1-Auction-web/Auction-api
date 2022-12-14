package com.project.service.users;


import com.project.model.users.Address;
import com.project.model.users.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    /**
     * By: HaiNT - Find list of users by param
     */
    List<User> getUserBy(String id, String name, String email, String userTypeId, String address);

    /**
     * By: HaiNT - Find list of users by id
     */
    Optional<User> findById(int id);

    /**
     * By: HaiNT - Find list of address by AddressId
     */
    Optional<Address> findByAddressId(int id);

    void updateAddress(User user);

    void updateUser(User user);

    void unlockUser(Integer id);
}
