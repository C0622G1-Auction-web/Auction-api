package com.project.service.account;

import com.project.model.account.LockAccount;
import org.springframework.stereotype.Service;

public interface ILockAccountService {
    void lockAccount(Integer id);

    void addLockUser(LockAccount lockAccount);
}
