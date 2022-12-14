package com.project.service.users.impl;

<<<<<<< HEAD
import com.project.model.users.Address;
import com.project.model.users.User;
=======
import com.project.dto.user.UserTopDto;
>>>>>>> 3ed5b9d1cd609697f7849ce200f58ade76d68f4e
import com.project.repository.users.IUserRepository;
import com.project.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> 3ed5b9d1cd609697f7849ce200f58ade76d68f4e

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

<<<<<<< HEAD
    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
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
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param id
     * @return User object by id
     */
    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findUserById(id);
    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param id
     * @return Object Address by id
     */
    @Override
    public Optional<Address> findByAddressId(int id) {
        return userRepository.findUserByAddressId(id);
    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param user
     */
    @Override
    public void updateAddress(User user) {
        userRepository.save(user);
    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        updateAddress(user);
        userRepository.updateUser(user.getId(), user.getIdCard(), user.getAvatar(), user.getBirthDay(), user.getEmail(),
                user.getFirstName(), user.getLastName(), user.getPhone());
    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param id
     * @return User object by id
     */
    @Override
    public List<User> findByIdList(List<Integer> id) {
        return userRepository.findUserByIdList(id);
    }

//    @Override
//    public List<User> findByIdList(List<Integer> id) {
//        return userRepository.findUserByIdList(id);
//    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param idList
     */
    @Override
    public void unlockUser(List<Integer> idList) {
        userRepository.unlockAccount(idList);
    }


=======

    /**
     * Created: SangDD
     * Created date: 13/12/2022
     * Function: get Top 10 users with the highest total money auction
     * @param quality user quality
     * @return List<User>
     */
    @Override
    public List<UserTopDto> getTopAuctionUser(String quality) {

        return userRepository.getTopAuctionUser(quality);
    }
>>>>>>> 3ed5b9d1cd609697f7849ce200f58ade76d68f4e
}
