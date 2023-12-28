package com.example.bitchair.config;

import com.example.bitchair.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author nankex.
 * @data 2023/3/15.
 */
@Configuration
public class InterceptorConfigurer implements WebMvcConfigurer {
    private Logger logger = LoggerFactory.getLogger(InterceptorConfigurer.class);
    @Bean
    public LoginInterceptor getLoginInterceptor(){
        System.out.println("注入了Interceptor");
        return new LoginInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getLoginInterceptor()).addPathPatterns();
        logger.info("============添加拦截器============");
    }
}
