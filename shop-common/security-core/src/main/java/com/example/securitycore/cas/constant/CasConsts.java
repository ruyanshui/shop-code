package com.example.securitycore.cas.constant;

/**
 * 单点登录配置类
 */
public class CasConsts {

    // CAS server地址
    public static final String CAS_SERVER_URL_PREFIX = "http://127.0.0.1:8080/cas";

    // 单点登录地址
    public static final String CAS_SERVER_LOGIN_URL = CAS_SERVER_URL_PREFIX + "/login";

    // 单点登出地址
    public static final String CAS_SERVER_LOGOUt_URL = CAS_SERVER_LOGIN_URL +"/logout";

    // 对外提供的服务地址值
    public static final String SERVER_URL_PREFIX = "http://127.0.0.1:8080";

    // casFilter urlPattern
    public static final String CAS_FILTER_URL_PATTERN = "/cas";

    // 登录地址
    public static final String LOGIN_URL = CAS_SERVER_LOGIN_URL + "?server=" + SERVER_URL_PREFIX + CAS_FILTER_URL_PATTERN;

    // 登出地址
    public static final String LOGOUT_URL = CAS_SERVER_LOGOUt_URL + "?server=" + SERVER_URL_PREFIX;

    // 登录成功地址
    public static final String LOGIN_SUCCESS_URL = "/toIndex";

    // 权限认证失败跳转地址
    public static final String UNUATHORIZED_URL = "/error/403.html";

}
