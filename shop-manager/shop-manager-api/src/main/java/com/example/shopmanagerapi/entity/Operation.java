package com.example.shopmanagerapi.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Operation implements Serializable {

    private static final long serialVersionUID = 1601604273540391919L;

    private int id;
    private String desc;
    private String name;
    private String opration;


}
