package com.example.securitycore.cas.casRealm;

import org.apache.shiro.cas.CasRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class ShiroCasRealm extends CasRealm {

    private static final Logger log = LoggerFactory.getLogger(ShiroCasRealm.class);

    @PostConstruct
    public void initProperty() {

    }

}
