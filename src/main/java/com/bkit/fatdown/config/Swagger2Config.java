package com.bkit.fatdown.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @FileName: Swagger2Config
 * @Author: YuJian
 * @Description: Swagger2文档生成配置
 * @Date: Created in 2019/7/9 17:25
 * @Modified:
 * @Version: 1.0
 */

@Configuration
public class Swagger2Config {

    /**
     * @description: 配置swagger文档
     * @params: null
     * @return:
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 2019/7/11
     */

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 设置扫描基础包
                .apis(RequestHandlerSelectors.basePackage("com.bkit.fatdown"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * @Description: 配置接口信息
     * @Param: null
     * @return: ApiInfo
     * @Author: YuJian
     * @date: 2019/7/4
     */

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("葆康减脂平台API文档")
                .description("版本日期:2019年7月11日,修改日期:2019年7月11日")
//                .termsOfServiceUrl("http://")
                .version("1.1.1")
                .build();
    }
}
