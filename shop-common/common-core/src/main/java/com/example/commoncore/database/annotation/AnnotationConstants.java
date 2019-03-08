package com.example.commoncore.database.annotation;


import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.ClassUtils;

import static com.example.commoncore.database.config.BaseConfig.ENTITY_PACKAGES;

public class AnnotationConstants {

    public static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

    public final static String PACKAGE_PATTERN =
            ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
                    + ClassUtils.convertClassNameToResourcePath(ENTITY_PACKAGES)
                    + DEFAULT_RESOURCE_PATTERN;
}
