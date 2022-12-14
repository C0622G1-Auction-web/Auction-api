package com.project.service.users.impl;

import com.project.model.users.Address;
import com.project.model.users.User;
import com.project.repository.users.IUserRepository;
import com.project.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    /**
     * By: HaiNT
     * @param id
     * @param name
     * @param email
     * @param userTypeId
     * @param address
     * @return List of users by param
     */
    @Override
    public List<User> getUserBy(String id, String name, String email, String userTypeId, String address) {
        return userRepository.getUserBy(id, name, email, userTypeId, address);
    }

    /**
     * By: HaiNT
     * @param id
     * @return User object by id
     */
    @Override
    public Optional<User> findById(int id) {
        return userRepository.findUserById(id);
    }

    /**
     * By: HaiNT
     * @param id
     * @return Object Address by id
     */
    @Override
    public Optional<Address> findByAddressId(int id) {
        return userRepository.findUserByAddressId(id);
    }

    /**
     * By: HaiNT
     * @param user
     */
    @Override
    public void updateAddress(User user) {
        userRepository.save(user);
    }

    /**
     * By: HaiNT
     * @param user
     */
    @Override
    public void updateUser(User user) {
        updateAddress(user);
        userRepository.updateUser(user.getId(), user.getIdCard(), user.getAvatar(), user.getBirthDay(), user.getEmail(),
                user.getFirstName(), user.getLastName(), user.getPhone());
    }

    /**
     * By: HaiNT
     * @param id
     */
    @Override
    public void unlockUser(Integer id) {
        userRepository.unlockAccount(id);
    }


}
