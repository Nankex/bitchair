package com.example.bitchair.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author nankex.
 * @data 2023/6/13.
 */
@Configuration
@EnableSwagger2//启用Swagger2功能
public class SawggerConfig {
    /**
     * 配置Swagger2相关的bean
     */
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com"))//com包下所有api都交由Sawgger2管理
                .paths(PathSelectors.any())
                .build();
    }
    /**
     * 此处主要是API文档页面显示信息
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("比特币交易溯源查询系统API") //标题
                .description("比特币交易溯源查询系统的Swagger2演示")//描述
                .version("1.0")
                .build();
    }
}
