package com.example.shopmanagerservice.mapper;

import com.example.commoncore.database.annotation.MybatisRepository;
import com.example.shopmanagerapi.entity.SysUser;
import org.apache.ibatis.annotations.Param;

@MybatisRepository
public interface SysUserMapper {

    SysUser getSysUserInfo(@Param("username")String username, @Param("password")String password);

    SysUser getUserInfoByUsername(@Param("username") String username);

}
