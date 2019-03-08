package com.example.shopmanagerapi.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 权限信息实体类
 */
@Data
public class Permission implements Serializable {

    private static final long serialVersionUID = -2883366130900641753L;

    private int id;
    private String pdesc;
    private String name;
    private Menu menu;
    private Set<Operation> operations = new HashSet<>();
}
