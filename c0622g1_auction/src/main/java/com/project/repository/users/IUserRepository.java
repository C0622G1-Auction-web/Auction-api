package com.project.repository.users;

import com.project.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
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
     * Create by: TruongLH
     * Date created: 13/12/2022
     * Function: to find by id
     * @param id
     * @return Optional<User>
     */
    @Query(value = "select * " +
            "from user u " +
            "where u.id= :id " +
            "and u.delete_status=1 ",
            nativeQuery = true)
    Optional<User> findUserById(@Param("id") int id);


}
