package com.project.service.users.impl;

import com.project.model.users.Address;
import com.project.model.users.User;
import com.project.repository.users.IUserRepository;
import com.project.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.createUser(
                user.getAvatar(),
                user.getBirthDay(),
                user.getDeleteStatus(),
                user.getEmail(),
                user.getFirstName(),
                user.getIdCard(),
                user.getLastName(),
                user.getPhone(),
                user.getPointDedication(),
                user.getAccount(),
                user.getAddress(),
                user.getUserType());

    }
    public void saveAddress(Address address) {
        userRepository.saveAddress(
                address.getId(),
                address.getDetailAddress(),
                address.getTown(),
                address.getDistrict(),
                address.getCity(),
                address.getCountry());
    }
}
