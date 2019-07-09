package com.bkit.fatdown;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @FileName: FatdownApplication
 * @Author: YuJian
 * @Description:  启动程序并打包成war文件
 * @Date: Created in 2019/7/9  14:01
 * @Modified:
 * @Version: 1.0
 */

@EnableSwagger2
@MapperScan("com.bkit.fatdown.mappers")
@SpringBootApplication
public class FatdownApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FatdownApplication.class, args);
    }


    /**
     * @Description: 继承SpringBootServletInitializer 实现configure 方便打war 外部服务器部署。
     * @Param: SpringApplicationBuilder
     * @return: SpringApplicationBuilder
     * @Author: YuJian
     * @date: 2019/7/9
     */

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(FatdownApplication.class);
    }
}
