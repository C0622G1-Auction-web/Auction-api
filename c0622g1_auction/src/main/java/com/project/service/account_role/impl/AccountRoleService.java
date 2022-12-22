package com.project.service.account_role.impl;


import com.project.repository.account.IAccountRoleRepository;
import com.project.service.account_role.IAccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountRoleService implements IAccountRoleService {

    @Autowired
    private IAccountRoleRepository accountRoleRepository;

    @Override
    public void createAccountRole(Integer accountId, Integer roleId) {
        accountRoleRepository.createAccountRole(accountId,roleId);
    }

}