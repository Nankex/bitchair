package com.example.bitchair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author nankex.
 * @data 2023/3/20.
 */
@Controller
public class ErrorController {
    @GetMapping("/Error")
    public ModelAndView Error(){
        ModelAndView modelAndView = new ModelAndView("pages-404");
        return modelAndView;
    }
}
