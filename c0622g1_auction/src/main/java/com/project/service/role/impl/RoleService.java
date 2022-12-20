package com.project.service.role.impl;

import com.project.model.account.Role;
import com.project.repository.role.IRoleRepository;
import com.project.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    /**
     * Create by: DucDH
     * Date: 17/12/2022
     * Function: To get list Role by Account id
     * @param accountId
     * @return List<Role>
     */

    @Override
    public List<Role> getListRoleByAccountId(Integer accountId) {
        return roleRepository.getListRoleByAccountId(accountId);
    }
}
