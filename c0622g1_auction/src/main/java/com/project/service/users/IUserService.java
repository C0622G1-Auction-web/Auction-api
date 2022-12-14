package com.project.service.users;


<<<<<<< HEAD
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
     * @param id
     */
    Optional<User> findById(Integer id);

    /**
     * By: HaiNT - Find list of users by idList
     * @return
     */
    List<User> findByIdList(List<Integer> id);

    /**
     * By: HaiNT - Find list of address by AddressId
     */
    Optional<Address> findByAddressId(int id);

    void updateAddress(User user);

    void updateUser(User user);

    void unlockUser(List<Integer> idList);
=======
import com.project.dto.user.UserTopDto;

import java.util.List;

public interface IUserService {
    /**
     * Created: SangDD
     * Created date: 13/12/2022
     * Function: get Top 10 users with the highest total money auction
     * @param quality user quality
     * @return List<User>
     */
    List<UserTopDto> getTopAuctionUser(String quality);
>>>>>>> 3ed5b9d1cd609697f7849ce200f58ade76d68f4e
}
