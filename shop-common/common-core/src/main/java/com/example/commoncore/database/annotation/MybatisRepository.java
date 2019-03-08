package com.example.commoncore.database.annotation;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 定义一个元注解类扫描repository接口类
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
@Mapper
public @interface MybatisRepository {
    String value() default "";
}
