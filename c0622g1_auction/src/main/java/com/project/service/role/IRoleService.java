package com.project.service.role;

import com.project.model.account.Role;

import java.util.List;

public interface IRoleService {

    /**
     * Create by: DucDH
     * Date: 17/12/2022
     * Function: To get list Role by Account id
     * @param accountId
     * @return List<Role>
     */

    List<Role> getListRoleByAccountId(Integer accountId);
}
