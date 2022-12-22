package com.project.service.account.impl;

import com.project.model.account.LockAccount;
import com.project.repository.account.ILockAccountRepository;
import com.project.service.account.ILockAccountService;
import org.springframework.stereotype.Service;


@Service
public class LockAccountService implements ILockAccountService {
    private ILockAccountRepository lockAccountRepository;
    @Override
    public void lockAccount(Integer id) {
        lockAccountRepository.lockAccount(id);
    }

    /**
     * Created by: VietNQ
     * */
    @Override
    public void addLockUser(LockAccount lockAccount) {
        lockAccountRepository.createLockUser(
                lockAccount.getStartDay(),
                lockAccount.getEndDay(),
                lockAccount.getReason(),
                lockAccount.getAccount().getId());
    }
}
