//package com.bkit.fatdown.config;
//
//import com.bkit.fatdown.common.power.UserRealm;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @file: ShiroConfig
// * @author: <a href="https://yujian95.cn/about/">YuJian</a>
// * @description: Shiro配置类
// * @date: Created in 8/17/19  2:12 PM
// * @modified:
// * @version: 1.0
// */
//@Configuration
//public class ShiroConfig {
//
//    /**
//     * 创建shiroFilterFactoryBean
//     *
//     * @return
//     */
//    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        // 设置安全管理器
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        return shiroFilterFactoryBean;
//    }
//
//    /**
//     * 创建defaultWebSecurityManager
//     *
//     * @return
//     */
//    @Bean(name = "securityManager")
//    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//
//        // 关联realm
//        securityManager.setRealm(userRealm);
//        return securityManager;
//    }
//
//    /**
//     * 创建realm
//     *
//     * @return
//     */
//    @Bean(name = "userRealm")
//    public UserRealm getRealm() {
//        return new UserRealm();
//    }
//}
