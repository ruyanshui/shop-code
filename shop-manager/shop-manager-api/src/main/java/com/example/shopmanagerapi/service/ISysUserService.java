package com.example.shopmanagerapi.service;

import com.example.shopmanagerapi.entity.SysRole;
import com.example.shopmanagerapi.entity.SysUser;

import java.util.Set;

/**
 * 系统用户信息处理接口类
 */
public interface ISysUserService {

    /**
     * 通过用户名和密码获取用户信息
     * @param username
     * @param password
     * @return
     */
    SysUser getSysUser(String username, String password);

    /**
     * 根据用户名获取用户角色
     * @param username
     * @return
     */
    Set<String> getRoles(String username);

    /**
     * 根据用户名获取用户权限
     * @param username
     * @return
     */
    Set<String> getPermissions(String username);

    /**
     * 通过用户名获取用户信息
     * @param username
     * @return
     */
    SysUser getUserInfoByUsername(String username);

    /**
     * 通过用户id获取角色集合
     * @param userId
     * @return
     */
    @Deprecated
    Set<SysRole> getUserRoles(int userId);

}
