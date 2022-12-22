package com.project.repository.account;

import com.project.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account, Integer> {

    /**
     * Created by UyenNC
     * Date created: 13/12/2022
     * Function: Search account by  username
     *
     * @param username
     * @return Account
     */

    /**
     * Created by UyenNC
     * Date created 13/12/2022
     * Function Find all valid account
     *
     * @return List<Account>
     */
    @Query(value = "select * from account " +
            "where delete_status = 0 " +
            "and status_lock = 0;", nativeQuery = true)
    List<Account> findAllAccount();

    /**
     * Created by UyenNC
     * Date created 13/12/2022
     * Function Update password for account with given id
     *
     * @param accountId
     * @param password
     */
    @Modifying
    @Query(value = "update `account` " +
            "set `password` =:password " +
            "where `id` =:accountId ", nativeQuery = true)
    void updateAccount(@Param(value = "accountId") Integer accountId,
                       @Param(value = "password") String password);

    /**
     * Created by UyenNC
     * Date created 13/12/2022
     * Function Find account by given id
     *
     * @param id
     * @return account
     */
    @Query(value = "select * from account " +
            "where id =:id " +
            "and delete_status = 0 " +
            "and status_lock = 1 ", nativeQuery = true)
    Account findAccountById(@Param(value = "id") Integer id);

    @Query(
            value = " select * " +
                    " from account " +
                    " where username = :username ",
            nativeQuery = true
    )
    Account findAccountByUsername(@Param("username") String username);;

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     *
     * @param username,password Function: to create account
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
     *
     * @param username,password Function: to update account
     * @return Account
     */
    @Modifying
    @Query(value = " update `account` " +
            "set `username` = :username, " +
            " `password` = :password",
            nativeQuery = true)
    Account updateAccount(@Param("username") String username,
                          @Param("password") String password);

    /**
     * Created by: VietNQ
     * */
    @Query(value = "select * from account " +
            "where id =:id ", nativeQuery = true)
    Account findLockAccountById(@Param(value = "id") Integer id);
}
