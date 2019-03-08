package com.example.shopmanagerservice.mapper;

import com.example.commoncore.database.annotation.MybatisRepository;
import com.example.shopmanagerapi.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MybatisRepository
public interface SysRoleMapper {

    List<SysRole> listUserRole(@Param("userId")int userId);

}
