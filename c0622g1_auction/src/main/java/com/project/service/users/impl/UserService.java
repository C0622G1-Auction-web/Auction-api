package com.project.service.users.impl;

<<<<<<< HEAD
import com.project.model.account.Account;
import com.project.model.users.Address;
import com.project.model.users.User;
import com.project.dto.user.UserTopDto;

import com.project.repository.account.IAccountRepository;
import com.project.repository.users.IAddressRepository;
=======
import com.project.dto.user.UserTopDto;
import com.project.model.users.Address;
import com.project.model.users.User;
>>>>>>> b529c2b05fbb822ab7b98de68978be70b2e4f8a4
import com.project.repository.users.IUserRepository;
import com.project.service.users.IAddressService;
import com.project.service.users.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IAddressRepository addressRepository;
    @Autowired
    private IAccountRepository accountRepository;

    /**
     * Create by: VietNQ
     * Date created: 13/12/2022
     * Function: to create user
     * @return void
     */
    @Override
    public void saveUser(User user, Integer addressId, Integer accountId, Integer userType) {
        userRepository.addUser(
                user.getAvatar(),
                user.getBirthDay(),
                user.getDeleteStatus(),
                user.getEmail(),
                user.getFirstName(),
                user.getIdCard(),
                user.getLastName(),
                user.getPhone(),
                user.getPointDedication(),
                accountId,
                addressId,
                userType);
    }

    /**
     * Create by: VietNQ
     * Date created: 13/12/2022
     *Function: to lockAccount
     * @param id
     */
    public void lockUser(List<Integer> id) {
        userRepository.lockAccount(id);
    }
     /* Create by: HaiNT
     * Date created: 13/12/2022
     * @param id
     * @param name
     * @param email
     * @param userTypeId
     * @param address
     * @return List of users by param
     */
    @Override
    public Page<User> getUserBy(String id, String name, String email, String userTypeId, String address, Pageable pageable) {
        return userRepository.getUserBy(id, name, email, userTypeId, address, pageable);
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
        return addressRepository.findById(id);
    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param id
     * @return Object Account by id
     */
    @Override
    public Optional<Account> findByAccountId(int id) {
        return accountRepository.findById(id);
    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param user
     */
    @Override
    public void updateAddressByRoleAdmin(User user) {
        userRepository.save(user);
    }

<<<<<<< HEAD
//    @Override
//    public void updateAddressByRoleAdmin(User user) {
//        userRepository.updateAddress(user.getAddress().getId(),
//                user.getAddress().getDetailAddress(), user.getAddress().getTown(),
//                user.getAddress().getDistrict(), user.getAddress().getCity(),
//                user.getAddress().getCountry());
//    }
=======
    @Override
    public void updateUser(User user) {
    }

    @Override
    public void unlockUser(List<Integer> idList) {

    }
>>>>>>> b529c2b05fbb822ab7b98de68978be70b2e4f8a4

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param user
     */
    @Override
    public void updateUserByRoleAdmin(User user) {
        updateAddressByRoleAdmin(user);
        userRepository.updateUserByRoleAdmin(user.getId(), user.getIdCard(), user.getAvatar(), user.getBirthDay(), user.getEmail(),
                user.getFirstName(), user.getLastName(), user.getPhone());
    }

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
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
     * @param idList
     */
    @Override
    public void unlockAccountByIdList(List<Integer> idList) {
        userRepository.unlockAccountByIdList(idList);
    }

<<<<<<< HEAD

    @Override
    public void saveUser(User user, Integer addressId, Integer accountId, Integer userType) {
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
                accountId,
                addressId,
                userType);

    }


=======
>>>>>>> b529c2b05fbb822ab7b98de68978be70b2e4f8a4
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

}
