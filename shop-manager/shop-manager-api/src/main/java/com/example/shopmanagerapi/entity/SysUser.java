package com.example.shopmanagerapi.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 系统用户
 */
@Data
public class SysUser implements Serializable{

    private static final long serialVersionUID = -2797238666957135925L;

    // 用户Id
    private int id;

    // 用户名
    private String username;

    // 密码
    private String password;

    // 手机号
    private String phone;

    // 性别
    private String sex;

    // 电子邮箱
    private String email;

    // 备注
    private String mark;

    // 用户级别
    private String rank;

    // 上次登录时间
    private Date lastLogin;

    // 登录的IP地址
    private String loginIp;

    // 头像图片地址
    private String imageUrl;

    // 注册时间
    private Date regTime;

    // 账号是否被锁定
    private Boolean locked = Boolean.FALSE;

    // 权限
    private String rights;

    private Set<SysRole> roles;


}
