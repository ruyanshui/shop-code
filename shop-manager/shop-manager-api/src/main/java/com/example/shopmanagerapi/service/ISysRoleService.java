package com.example.shopmanagerapi.service;

import com.example.shopmanagerapi.entity.SysRole;

import java.util.Set;

/**
 * 角色业务接口
 */
public interface ISysRoleService {

    /**
     * 获取所有用户角色
     * @param userId
     * @return
     */
    Set<SysRole> getUserRoles(int userId);
}
