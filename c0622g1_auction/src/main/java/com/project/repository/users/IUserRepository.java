package com.project.repository.users;

import com.project.model.account.Account;
import com.project.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User,Integer> {
    /**Created by UyenNC
     * Date created 13/12/2022
     * Function Find user by account
     * @param accountId
     * @return User
     */
    @Query(value = "select * from user " +
            "where account_id =:accountId and delete_status = 0;", nativeQuery = true)
    User findUserByAccount(@Param("accountId") String accountId);
}
