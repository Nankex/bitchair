package com.example.bitchair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author nankex.
 * @data 2023/4/10.
 */
@Controller
public class AuthenticationController {
    @GetMapping("/Collection")
    public ModelAndView Collection(){
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
    @GetMapping("/Profile")
    public ModelAndView Profile(){
        ModelAndView modelAndView = new ModelAndView("auth-profile");
        return modelAndView;
    }
    @GetMapping("/Wallet")
    public ModelAndView Wallet(){
        ModelAndView modelAndView = new ModelAndView("auth-wallet");
        return modelAndView;
    }
}
