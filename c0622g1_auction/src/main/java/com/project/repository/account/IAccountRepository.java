package com.project.repository.account;

import com.project.model.account.Account;
import com.project.model.users.Address;
import com.project.model.users.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account,Integer> {

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * @param username,password
     * Function: to create account
     * @return Account
     */
    @Modifying
    @Query(value = "insert into " +
                   "account(username," +
                           "password," +
                   " values(:username," +
                           ":password)",
                   nativeQuery = true)
    Account createAccount(@Param("username") String username,
                          @Param("password") String password);
    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * @param username,password
     * Function: to update account
     * @return Account
     */
    @Modifying
    @Query(value = " update `account` " +
                   "set `username` = :username, " +
                      " `password` = :password",
                   nativeQuery = true)
    Account updateAccount(@Param("username") String username,
                          @Param("password") String password);

}
