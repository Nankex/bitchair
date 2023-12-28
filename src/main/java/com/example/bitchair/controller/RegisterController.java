package com.example.bitchair.controller;

import com.example.bitchair.entity.Account;
import com.example.bitchair.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author nankex.
 * @data 2023/3/3.
 */
@Controller
public class RegisterController {
    @Autowired
    AccountService accountService;
    @GetMapping("/Register")
    public ModelAndView Register(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        ModelAndView modelAndView = new ModelAndView("auth-register");
        return modelAndView;
    }
    @GetMapping("/UserRegister")
    public ModelAndView UserRegister(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        ModelAndView modelAndView = new ModelAndView("");
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("userpassword");
        String email = httpServletRequest.getParameter("useremail");
        Account account = new Account(username,password,email);
        accountService.saveAccount(account);
        return modelAndView;
    }
}
