package com.example.bitchair.interceptor;

import com.example.bitchair.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author nankex.
 * @data 2023/3/15.
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    public AccountService accountService;

//    @Autowired
//    public PowerService powerService;

}
