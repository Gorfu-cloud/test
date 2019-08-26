package com.bkit.fatdown.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @file: MyBatisConfig
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: MyBatis配置类
 * @date: Created in 8/26/19  11:17 PM
 * @modified:
 * @version: 1.0
 */
@Configuration
@MapperScan("com.bkit.fatdown.mappers")
public class MyBatisConfig {
}
