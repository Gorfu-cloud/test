package com.bkit.fatdown;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @file: FatdownApplication
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 启动程序并打包成war文件
 * @date: Created in 7/22/19  1:59 PM
 * @modified:
 * @version: 2.0.6
 */
@SpringBootApplication
public class FatdownApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FatdownApplication.class, args);
    }

    /**
     * @description: 继承SpringBootServletInitializer 实现configure 方便打war 外部服务器部署。
     * @params:
     * @return:
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 7/22/19
     */

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(FatdownApplication.class);
    }
}
