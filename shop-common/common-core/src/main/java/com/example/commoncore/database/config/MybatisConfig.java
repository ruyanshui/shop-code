package com.example.commoncore.database.config;


import com.example.commoncore.database.annotation.MybatisRepository;
import com.example.commoncore.database.annotation.TypeAliasesPackageScanner;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.sql.DataSource;

import static com.example.commoncore.database.config.BaseConfig.*;

@MapperScan(basePackages = MAPPER_PACKAGES,
            annotationClass = MybatisRepository.class,
            sqlSessionFactoryRef = SQL_SESSION_FACTORY)

@ComponentScan
@EnableTransactionManagement
@Configuration
public class MybatisConfig {

    @Autowired
    MybatisSqlInterceptor mybatisSqlInterceptor;

    TypeAliasesPackageScanner packageScanner = new TypeAliasesPackageScanner();

    @Bean(name=DATA_SOURCE_NAME)
    @ConfigurationProperties(prefix = DATA_SOURCE_PROPERTIES)
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = SQL_SESSION_FACTORY)
    public SqlSessionFactory sqlSessionFactory(@Qualifier(DATA_SOURCE_NAME)DataSource dataSource)throws Exception{
        //SpringBoot默认使用DefaultVFS进行扫描，但是没有扫描到jar里的实体类
        VFS.addImplClass(SpringBootVFS.class);
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setPlugins(new Interceptor[]{mybatisSqlInterceptor});
        factoryBean.setDataSource(dataSource);
        //factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try{
            factoryBean.setMapperLocations(resolver.getResources("classpath*:/mybatis/*Mapper.xml"));
            String typeAliasesPackage = packageScanner.getTypeAliasesPackages();
            factoryBean.setTypeAliasesPackage(typeAliasesPackage);
            SqlSessionFactory sqlSessionFactory = factoryBean.getObject();
            return sqlSessionFactory;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Bean(name = MYBATIS_TRANSACTION_MANAGER)
    public DataSourceTransactionManager transactionManager(@Qualifier(DATA_SOURCE_NAME)DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
