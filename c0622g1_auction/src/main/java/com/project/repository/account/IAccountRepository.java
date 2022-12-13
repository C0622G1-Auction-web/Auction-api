package com.project.repository.account;

import com.project.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account, Integer> {

    @Modifying
    @Query(value = "insert into " +
            "account(" +
            "id," +
            "username," +
            "password)"+
            "values(:id,:username,:password)",
            nativeQuery = true)
    void saveAccount(
            @Param("id") Integer id,
            @Param("username") String username,
            @Param("password") String password);
}
