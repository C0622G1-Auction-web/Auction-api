package com.project.service.account.impl;


import com.project.model.account.LockAccount;
import com.project.repository.account.ILockAccountRepository;
import com.project.service.account.ILockAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LockAccountService implements ILockAccountService {

    @Autowired
    private ILockAccountRepository lockAccountRepository;


    @Override
    public void addLockUser(LockAccount lockAccount) {
        lockAccountRepository.createLockUser(
                lockAccount.getStartDay(),
                lockAccount.getEndDay(),
                lockAccount.getReason(),
                lockAccount.getAccount().getId());
    }
}
