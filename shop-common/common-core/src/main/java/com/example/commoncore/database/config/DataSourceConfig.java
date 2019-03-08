package com.example.commoncore.database.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import static com.example.commoncore.database.config.BaseConfig.DATA_SOURCE_NAME;
import static com.example.commoncore.database.config.BaseConfig.DATA_SOURCE_PROPERTIES;

@Configuration
public class DataSourceConfig {

    @Bean(name = DATA_SOURCE_NAME)
    @ConfigurationProperties(prefix = DATA_SOURCE_PROPERTIES)
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }
}
