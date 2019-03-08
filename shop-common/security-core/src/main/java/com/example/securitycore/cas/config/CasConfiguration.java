package com.example.securitycore.cas.config;

import com.example.securitycore.shiro.reaml.CommonShiroRealm;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 单点登录配置类
 */
@Configuration
public class CasConfiguration {

    private static final Logger log = LoggerFactory.getLogger(CasConfiguration.class);

    @Bean
    public CommonShiroRealm getShiroRealm() {
        CommonShiroRealm commonShiroRealm = new CommonShiroRealm();
        return commonShiroRealm;
    }


    /**
     * 单点登出监听器
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new SingleSignOutHttpSessionListener());
        servletListenerRegistrationBean.setEnabled(true);
        return servletListenerRegistrationBean;
    }

}
