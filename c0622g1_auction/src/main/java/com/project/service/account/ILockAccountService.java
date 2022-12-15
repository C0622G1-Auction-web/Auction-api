package com.project.service.account;

import org.springframework.stereotype.Service;

@Service
public interface ILockAccountService {
    void lockAccount(Integer id);
}
