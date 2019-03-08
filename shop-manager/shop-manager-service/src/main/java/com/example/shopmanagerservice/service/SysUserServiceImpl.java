package com.example.shopmanagerservice.service;

import com.example.shopmanagerapi.entity.Operation;
import com.example.shopmanagerapi.entity.Permission;
import com.example.shopmanagerapi.entity.SysRole;
import com.example.shopmanagerapi.entity.SysUser;
import com.example.shopmanagerapi.service.ISysUserService;
import com.example.shopmanagerservice.mapper.SysRoleMapper;
import com.example.shopmanagerservice.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户信息管理业务类
 */
@Service
public class SysUserServiceImpl implements ISysUserService {


    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysRoleMapper sysRoleMapper;



    @Override
    public SysUser getSysUser(String username, String password) {
        return sysUserMapper.getSysUserInfo(username, password);
    }

    @Override
    public Set<String> getRoles(String username) {
        SysUser user = getUserInfoByUsername(username);
        Set<SysRole> roles = user.getRoles();
        Set<String> roleStrs = new HashSet<>();
        for(SysRole r : roles) {
            roleStrs.add(r.getRole());
        }
        return roleStrs;
    }

    @Override
    public Set<String> getPermissions(String username) {
        SysUser user = this.getUserInfoByUsername(username);
        Set<SysRole> roles = user.getRoles();
        /* 创建一个HashSet来存放角色权限信息 */
        Set<String> permissions = new HashSet<String>();
        for(SysRole r : roles) {
            for (Permission p : r.getPermissions()){
                for(Operation o : p.getOperations()){
                    permissions.add(o.getOpration());
                }
            }
        }
        return permissions;
    }

    @Override
    public SysUser getUserInfoByUsername(String username) {
        return sysUserMapper.getUserInfoByUsername(username);
    }

    @Override
    public Set<SysRole> getUserRoles(int userId) {
        List<SysRole> roleList = sysRoleMapper.listUserRole(userId);
        Set<SysRole> roles = new HashSet<>(roleList);
        return roles;
    }
}
