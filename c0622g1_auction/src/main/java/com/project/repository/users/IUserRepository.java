package com.project.repository.users;

import com.project.dto.user.UserTopDto;
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
     * Create by: HaiNT
     * Date created: 13/12/2022
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
            "AND user.user_type_id like %:userTypeId% " +
            "GROUP BY user.id LIMIT :index,5", nativeQuery = true)
    List<User> getUserBy(
            @Param("id") String id,
            @Param("name") String name,
            @Param("email") String email,
            @Param("userTypeId") String userTypeId,
            @Param("address") String address,
            @Param("index") Integer index
    );

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
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
     * Create by: HaiNT
     * Date created: 13/12/2022
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
    void updateUserByRoleAdmin(@Param("id") Integer id,
                    @Param("idCard") String idCard,
                    @Param("avatar") String avatar,
                    @Param("birthDay") String birthDay,
                    @Param("email") String email,
                    @Param("firstName") String firstName,
                    @Param("lastName") String lastName,
                    @Param("phone") String phone
    );

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     *
     * @param idList
     * @return List User by idList
     */
    @Query(value = "select * " +
            "from user u " +
            "where u.id in :idList ",
            nativeQuery = true)
    List<User> findUserByIdList(List<Integer> idList);

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     * Function: to unlock account by id
     *
     * @param idList
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE auction_api.account SET status_lock = 1 WHERE (id in :idList);", nativeQuery = true)
    void unlockAccountByIdList(@Param("idList") List<Integer> idList);

    /**
     * Create by: HaiNT
     * Date created: 13/12/2022
     * Function: to  find Address by id
     *
     * @param id
     * @return Optional<Address>
     */
    @Query(value = "SELECT * FROM auction_api.address WHERE id = :id ",
            nativeQuery = true)
    Optional<Address> findUserByAddressId(@Param("id") Integer id);

    /**
     * Create by: VietNQ
     * Date created: 13/12/2022
     * Function: to create user
     *
     * @return HttpStatus.OK
     */
    @Modifying
    @Query(value = "insert into " +
            "user(avatar," +
            "birth_day," +
            "delete_status," +
            "email," +
            "first_name," +
            "id_card," +
            "last_name," +
            "phone," +
            "point_dedication," +
            "account_id," +
            "address_id," +
            "user_type_id)" +
            " values (" +
            ":avatar," +
            ":birthDay," +
            ":deleteStatus," +
            ":email," +
            ":fistName," +
            ":idCard," +
            ":lastName," +
            ":phone," +
            ":pointDedication," +
            ":accountId," +
            ":addressId," +
            ":userTypeId)",
            nativeQuery = true)
    void createUser(@Param("avatar") String avatar,
                    @Param("birthDay") String birthDay,
                    @Param("deleteStatus") Boolean deleteStatus,
                    @Param("email") String email,
                    @Param("fistName") String fistName,
                    @Param("idCard") String idCard,
                    @Param("lastName") String lastName,
                    @Param("phone") String phone,
                    @Param("pointDedication") Double pointDedication,
                    @Param("accountId") Integer accountId,
                    @Param("addressId") Integer addressId,
                    @Param("userTypeId") Integer userTypeId);


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
    Optional<User> findUserById(@Param("id") Integer id);


    /**
     * Created: SangDD
     * Created date: 13/12/2022
     * Function: get Top 10 users with the highest total money auction
     *
     * @return List<User>
     */
    @Query(value = "SELECT " +
            "user.first_name, " +
            "user.last_name, " +
            "sum(a.current_price) as total_money_auction, " +
            "user.avatar, " +
            "user.email " +
            "FROM user " +
            "    RIGHT JOIN auction a on user.id = a.user_id\n" +
            "    RIGHT JOIN  payment p on a.id = p.auction_id\n" +
            "WHERE a.pay_status = 1 " +
            "    AND user.delete_status = 0 " +
            "GROUP By user.id " +
            "ORDER BY total_money_auction DESC " +
            "LIMIT :quality ",
            nativeQuery = true)
    List<UserTopDto> getTopAuctionUser(@Param("quality") String quality);

}
