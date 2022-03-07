package com.boot.tool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .consumes(DEFAULT_CONSUMES) // 请求类型
                .produces(DEFAULT_PRODUCES) // 返回类型
                .groupName("account")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.boot.controller"))
                .build();
    }


    /**
     * 请求 content-Type 配置
     */
    private static final Set<String> DEFAULT_CONSUMES =
            new HashSet<String>(Arrays.asList("application/x-www-form-urlencoded", "application/x-www-form-urlencoded"));
    /**
     * 返回 content-Type 配置
     */
    private static final Set<String> DEFAULT_PRODUCES =
            new HashSet<String>(Arrays.asList("application/json", "application/json"));

    /**
     * 配置
     *
     * @return 配置信息
     */
    private ApiInfo apiInfo() {
        Contact contact = new Contact("yk", "https://weibo.com/u/5202880237", "gybond1995@foxmail.com");
        return new ApiInfo(
                "账号管理", // title
                "各个平台的账号管理", // description
                "v1.0.0", // version
                "https://weibo.com/u/5202880237", //组织链接
                contact, // 联系人信息
                "Apach 2.0 许可", // 许可
                "", // 许可链接
                new ArrayList<>()
        );
    }
}
