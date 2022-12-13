package com.project.repository.account;

import com.project.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account,Integer> {

    @Query(
            value = " select " +
                    "   account.id, " +
                    "   account.username " +
                    "   account.password " +
                    "   account.statusLock " +
                    "   account.deleteStatus " +
                    " from account where username = :username ",
            nativeQuery = true
    )
    Account findAccountByUsername(@Param("username") String username);

}
