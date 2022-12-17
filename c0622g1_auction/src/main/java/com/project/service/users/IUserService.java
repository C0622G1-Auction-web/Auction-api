package com.project.service.users;

import com.project.dto.user.UserTopDto;
import com.project.model.account.Account;
import com.project.model.users.Address;
import com.project.model.users.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface IUserService {


    /**
     * By: HaiNT - Find list of users by param
     */
    Page<User> getUserBy(String id, String name, String email, String userType, String address, Pageable pageable);

    /**
     * By: HaiNT - Find list of users by id
     *
     * @param id
     */
    Optional<User> findById(Integer id);

    /**
     * By: HaiNT - Find list of users by idList
     *
     * @return
     */
    List<User> findByIdList(List<Integer> id);

    /**
     * By: HaiNT - Find list of address by AddressId
     */
    Optional<Address> findByAddressId(int id);

    /**
     * By: HaiNT - Find list of address by AddressId
     */
    Optional<Account> findByAccountId(int id);

    /**
     * By: HaiNT - Find list of address by AddressId
     */
    void updateAddressByRoleAdmin(User user);

    /**
     * By: HaiNT - Find list of address by AddressId
     */
    void updateUserByRoleAdmin(User user);

    /**
     * By: HaiNT - Find list of address by AddressId
     */
    void unlockAccountByIdList(List<Integer> idList);

    /**
     * Created: SangDD
     * Created date: 13/12/2022
     * Function: get Top 10 users with the highest total money auction
     *
     * @param quality user quality
     * @return List<User>
     */
    List<UserTopDto> getTopAuctionUser(String quality);


}

