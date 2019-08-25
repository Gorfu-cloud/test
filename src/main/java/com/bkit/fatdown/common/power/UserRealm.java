//package com.bkit.fatdown.common.power;
//
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//
///**
// * @file: UserRealm
// * @author: <a href="https://yujian95.cn/about/">YuJian</a>
// * @description: 用户权限
// * @date: Created in 8/17/19  2:15 PM
// * @modified:
// * @version: 1.0
// */
//
//public class UserRealm extends AuthorizingRealm {
//    /**
//     * 执行授权逻辑
//     *
//     * @param principalCollection
//     * @return
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("执行 授权逻辑");
//        return null;
//    }
//
//    /**
//     * 执行认证逻辑
//     *
//     * @param authenticationToken
//     * @return
//     * @throws AuthenticationException
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        System.out.println("执行 认证逻辑");
//        return null;
//    }
//}
