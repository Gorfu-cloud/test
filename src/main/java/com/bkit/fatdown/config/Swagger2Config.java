package com.bkit.fatdown.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * @file: Swagger2Config
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: Swagger2文档生成配置
 * @date: Created in 7/31/19  8:25 PM
 * @modified:
 * @version: 1.0
 */
@EnableSwagger2
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
                // 扫描使用Api注解的控制器
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                // 扫描使用ApiOperation注解的方法
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
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
     * @return 文档信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("葆康减脂平台API文档")
                // API描述
                .description("创建日期:2019年7月11日,修改日期:2019年8月07日")
                // 创建路径
                .termsOfServiceUrl(SERVICE_URL)
                .version("2.1.5")
                .build();
    }

    /**
     * 解决swagger显示问题
     *
     * @param registry 资源路径
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
