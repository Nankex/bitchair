package com.example.bitchair.config;

import com.example.bitchair.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nankex.
 * @data 2023/3/15.
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Qualifier("getLoginInterceptor")
    @Autowired
    private LoginInterceptor loginHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration ir = registry.addInterceptor(loginHandlerInterceptor);
        // 拦截路径
//        ir.addPathPatterns("/*");
//        ir.addPathPatterns("/Buyit");
        // 不拦截路径
        List<String> irs = new ArrayList<String>();
//        irs.add("/api/*");
//        irs.add("/wechat/*");
//        irs.add("/oauth");
        irs.add("/Login");
        irs.add("/Verify");
        irs.add("/Register");
        irs.add("/Index");
//        irs.add("/Power");
//        irs.add("/PowerLogin");
//        irs.add("/Cart");
//        irs.add("/static/*");
//        irs.add("/templates/*");
        ir.excludePathPatterns(irs);
    }
}