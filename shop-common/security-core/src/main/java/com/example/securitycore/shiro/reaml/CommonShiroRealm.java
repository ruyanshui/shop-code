package com.example.securitycore.shiro.reaml;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 基于Shiro框架的权限安全认证和授权
 */
public class CommonShiroRealm extends AuthorizingRealm{

    /**
     * 授权查询回调函数，进行鉴权但缓存中无用户的授权信息时调用，负责在应用程序中决定用户的访问控制的方法
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //authorizationInfo.setRoles(userService.getRoles(username));
	    //authorizationInfo.setStringPermissions(userService.getPermissions(username));

        return authorizationInfo;

    }


    /**
     * 登录信息和用户验证信息验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取用户名
        String username = (String) authenticationToken.getPrincipal();
        // 获取密码
        String password = new String ((char[]) authenticationToken.getCredentials());
        // AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        if (null != username && null != password) {
            return new SimpleAuthenticationInfo(username, password, getName());
        } else {
            return null;
        }


    }
}
