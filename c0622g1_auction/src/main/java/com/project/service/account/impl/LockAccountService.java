package com.project.service.account.impl;

import com.project.repository.account.ILockAccountRepository;
import com.project.service.account.ILockAccountService;
import org.springframework.stereotype.Service;


@Service
public class LockAccountService implements ILockAccountService {
    private ILockAccountRepository lockAccountRepository;
}
