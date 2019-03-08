package com.example.shopmanagerapi.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单信息实体类
 */
@Data
public class Menu implements Serializable{

    private static final long serialVersionUID = 2984389830642273415L;

    // 菜单Id
    private int menuId;

    // 上级Id
    private int parentId;

    // 菜单名称
    private String menuName;

    // 菜单图标
    private String menuIcon;

    // 菜单url
    private String menuUrl;

    // 菜单类型
    private String menuType;

    // 菜单排序
    private String menuOrder;

    // 菜单状态
    private String menuStatus;

    // 子级菜单
    private List<Menu> subMenu;

    private String target;

    // 是否有子级菜单
    private boolean hasSubMenu = false;
}
