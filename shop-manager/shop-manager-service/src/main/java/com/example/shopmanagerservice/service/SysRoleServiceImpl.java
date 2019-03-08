package com.example.shopmanagerservice.service;

import com.example.shopmanagerapi.entity.SysRole;
import com.example.shopmanagerapi.service.ISysRoleService;
import com.example.shopmanagerservice.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public Set<SysRole> getUserRoles(int userId) {
        List<SysRole> roleList = sysRoleMapper.listUserRole(userId);
        Set<SysRole> roles = new HashSet<>(roleList);
        return roles;
    }
}
