package com.project.service.role.impl;

import com.project.repository.account.IAccountRepository;
import com.project.service.role.IAccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountRoleService implements IAccountRoleService {

    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public void createAccountRole(Integer accountId, Integer roleId) {
        accountRepository.createAccountRole(accountId,roleId);

    }
}
