package com.example.shopmanagerapi.service;

import com.example.shopmanagerapi.entity.Permission;

import java.util.Set;

public interface ISysPermissionService {

    /**
     * 获取角色所有权限
     * @param roleId
     * @return
     */
    Set<Permission> getRolePermissions(int roleId);
}
