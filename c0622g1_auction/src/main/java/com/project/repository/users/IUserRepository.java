package com.project.repository.users;

import com.project.model.users.Address;
import com.project.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User, Integer> {


    /**
     * By: HaiNT
     *
     * @param id
     * @param name
     * @param email
     * @param userTypeId
     * @param address
     * @return List User
     */
    @Query(value = "SELECT * " +
            "FROM user " +
            "join address on address.id = user.address_id " +
            "JOIN `account` on `account`.id = user.account_id " +
            "JOIN user_type on user_type.id = user.user_type_id " +
            "WHERE user.id like %:id% " +
            "AND (user.first_name like %:name% or user.last_name like %:name%) " +
            "AND (address.detail_address LIKE %:address% OR address.town LIKE %:address% or address.district LIKE %:address% or address.city LIKE %:address% or address.country LIKE %:address%) " +
            "AND user.email like %:email% " +
            "AND user.user_type_id like %:userTypeId% ", nativeQuery = true)
    List<User> getUserBy(
            @Param("id") String id,
            @Param("name") String name,
            @Param("email") String email,
            @Param("userTypeId") String userTypeId,
            @Param("address") String address
    );

    /**
     * By: HaiNT
     *
     * @param id
     * @param city
     * @param detailAddress
     * @param district
     * @param town
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE auction_api.address " +
            "SET city = :city, " +
            "country = :country, " +
            "detail_address = :detailAddress, " +
            "district = :district, " +
            "town = :town" +
            " WHERE (`id` = :id) ", nativeQuery = true)
    void updateAddress(@Param("id") Integer id,
                       @Param("detailAddress") String detailAddress,
                       @Param("town") String town,
                       @Param("district") String district,
                       @Param("city") String city,
                       @Param("country") String country
    );

    /**
     * By: HaiNT
     *
     * @param id
     * @param idCard
     * @param avatar
     * @param birthDay
     * @param email
     * @param firstName
     * @param lastName
     * @param phone
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE auction_api.user " +
            "SET avatar = :avatar, " +
            "birth_day = :birthDay , " +
            "email = :email, " +
            "first_name = :firstName, " +
            "id_card = :idCard, " +
            "last_name = :lastName, " +
            "phone = :phone " +
            "WHERE (`id` = :id) ", nativeQuery = true)
    void updateUser(@Param("id") Integer id,
                    @Param("idCard") String idCard,
                    @Param("avatar") String avatar,
                    @Param("birthDay") String birthDay,
                    @Param("email") String email,
                    @Param("firstName") String firstName,
                    @Param("lastName") String lastName,
                    @Param("phone") String phone
    );

    /**
     * By: HaiNT
     * @param id
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE `auction_api`.`account` SET `status_lock` = 1 WHERE (`id` = :id);", nativeQuery = true)
    void unlockAccount(@Param("id") Integer id);


    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to find by id
     *
     * @param id
     * @return Optional<User>
     */
    @Query(value = "select * " +
            "from user u " +
            "where u.id= :id " +
            "and u.delete_status=1 ",
            nativeQuery = true)
    Optional<User> findUserById(@Param("id") int id);

    /**
     * By: HaiNT
     * @param id
     * @return
     */
    @Query(value = "SELECT * FROM auction_api.address WHERE id = :id ",
            nativeQuery = true)
    Optional<Address> findUserByAddressId(@Param("id") int id);

}
