package com.bkit.fatdown.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @FileName: Swagger2Config
 * @Author: YuJian
 * @Description: Swagger2文档生成配置
 * @Date: Created in 2019/7/9 17:25
 * @Modified: 2019年7月11日 14点36分 修改版本
 * @Version: 1.0
 */

@Configuration
public class Swagger2Config extends WebMvcConfigurationSupport {

    /**
     * 配置扫描的api控制包路径
     */
    private static final String BASE_PACKAGE = "com.bkit.fatdown.controller";
    /**
     * 服务器路径
     */
    private static final String SERVICE_URL = "https://sunnyqcloud.com/fatdown";


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
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public RequestMappingInfoHandlerMapping requestMapping() {
        return new RequestMappingHandlerMapping();
    }

    /**
     * 配置 api 文档信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("葆康减脂平台API文档")
                // API描述
                .description("创建日期:2019年7月11日,修改日期:2019年7月18日")
                // 创建路径
                .termsOfServiceUrl(SERVICE_URL)
                .version("2.0.5")
                .build();
    }

    /**
     * 解决swagger显示问题
     *
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 解决静态资源无法访问
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        // 解决swagger无法访问
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        // 解决swagger的js文件无法访问
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
