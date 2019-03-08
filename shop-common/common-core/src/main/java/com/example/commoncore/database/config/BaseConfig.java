package com.example.commoncore.database.config;

public class BaseConfig {

    /**
     * 设置主数据源名称
     */
    public static final String DATA_SOURCE_NAME = "shop";

    /**
     * 加载配置文件信息
     */
    public static final String DATA_SOURCE_PROPERTIES = "spring.datasource.shop";

    /**
     * repository 所在包
     */
    public static final String REPOSITORY_PACKAGES = "com.muses.taoshop.**.repository";

    /**
     * mapper 所在包
     */
    public static final String MAPPER_PACKAGES = "com.muses.taoshop.**.mapper";

    /**
     * 实体类 所在包
     */
    public static final String ENTITY_PACKAGES = "com.example.shop.*.entity";

    /**
     * 自定义TypeHandler
     */
    public static final String TYPE_HANDLERS_PACKAGES = "com.muses.taoshop.common.core.database.typehandlers";

    /**
     * Mybatis session 工厂
     */
    public static final String SQL_SESSION_FACTORY = "sqlSessionFactory";

    /**
     * Mybatis 事务管理器
     */
    public static final String MYBATIS_TRANSACTION_MANAGER = "mybatisTransactionManager";

    /**
     * Jedis连接池
     */
    public static final String JEDIS_POOL = "jedisPool";

    /**
     * Jedis连接池配置
     */
    public static final String JEDIS_POOL_CONFIG = "jedisPoolConfig";

}
