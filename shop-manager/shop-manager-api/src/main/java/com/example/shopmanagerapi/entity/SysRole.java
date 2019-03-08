package com.example.shopmanagerapi.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色信息实体类
 */
@Data
public class SysRole implements Serializable{

    private static final long serialVersionUID = 2975834198022196851L;

    // 角色ID
    private int roleId;

    // 角色描述
    private String roleDesc;

    // 角色名称
    private String roleName;

    // 角色标志
    private String role;

    private Set<Permission> permissions = new HashSet<>();
}
