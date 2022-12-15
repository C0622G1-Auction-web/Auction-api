package com.project.service.users.impl;

<<<<<<< HEAD
import com.project.model.account.Account;
=======
import com.project.model.users.User;
import com.project.dto.user.UserTopDto;
import com.project.model.users.Address;
>>>>>>> 14a5abf94087479d86462c46f3e7e5fff1310c4b
import com.project.model.users.User;
import com.project.repository.users.IUserRepository;
import com.project.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
=======

>>>>>>> 14a5abf94087479d86462c46f3e7e5fff1310c4b
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

<<<<<<< HEAD
    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to update user
     *
     * @param user
     * @return User
     */

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(
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
                user.getUserType(),
                user.getId());
    }

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to create user
     *
     * @param user
     * @return User
     */

    @Override
    public void createUser(User user) {
=======
    @Override
    public void saveUser(User user, Integer addressId, Integer accountId,Integer userType) {
>>>>>>> 14a5abf94087479d86462c46f3e7e5fff1310c4b
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
<<<<<<< HEAD
                user.getAccount(),
                user.getAddress(),
                user.getUserType());
    }

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to find user by id
     *
     * @param id
     * @return User
     */

    @Override
    public Optional<User> findUserById(int id) {
=======
                accountId,
                addressId,
                userType);

    }

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
>>>>>>> 14a5abf94087479d86462c46f3e7e5fff1310c4b
        return userRepository.findUserById(id);
    }

    /**
<<<<<<< HEAD
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to find all user list
     *
     * @return List<User>
     */

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

=======
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


    /**
     * Created: SangDD
     * Created date: 13/12/2022
     * Function: get Top 10 users with the highest total money auction
     *
     * @param quality user quality
     * @return List<User>
     */
    @Override
    public List<UserTopDto> getTopAuctionUser(String quality) {

        return userRepository.getTopAuctionUser(quality);
    }
>>>>>>> 14a5abf94087479d86462c46f3e7e5fff1310c4b
}
