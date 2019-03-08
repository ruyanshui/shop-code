package com.example.commoncore.base;

/**
 * 返回结果枚举类
 */
public enum ResultStatus {
    OK("200","OK","成功"),
    VALIDATION_ERROR("400","Validation Error","参数校验异常"),
    AUTHENTICATION_ERROR("300","Authentication Error","身份认证异常");

    private final String statusCode;

    private final String resonPhrase;

    private final String message;

    private ResultStatus(String statusCode, String resonPhrase, String message) {
        this.statusCode = statusCode;
        this.resonPhrase = resonPhrase;
        this.message = message;
    }
}
