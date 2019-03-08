package com.example.shopmanagerapi.service;

import com.example.shopmanagerapi.entity.Menu;

import java.util.List;

public interface IMenuService {

    /**
     * 根据权限id获取菜单
     * @param permissionId
     * @return
     */
    Menu listMenu(int permissionId);


    /**
     * 权限菜单获取，根据用户角色获取用户可以查看的菜单
     * @param userId
     * @return
     */
    List<Menu> listPermissionMenu(int userId);
}
