package com.example.bitchair.controller;

import com.example.bitchair.entity.Account;
import com.example.bitchair.entity.Circulation;
import com.example.bitchair.entity.Price;
import com.example.bitchair.service.CirculationService;
import com.example.bitchair.service.PriceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author nankex.
 * @data 2023/3/20.
 */
@Controller
public class IndexController {
    @Resource
    PriceService priceService;
    @Resource
    CirculationService circulationService;
    @GetMapping("/Index")
    public ModelAndView Index(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("index");
        Account account =(Account) httpSession.getAttribute("account");
        modelAndView.addObject("username",account.getUsername());
        List<Price> list = priceService.findAllPrice();
        System.out.println("list = " + list);
        modelAndView.addObject("list",list);
        List<Circulation> circulationList = circulationService.findAllCir();
        modelAndView.addObject("circulationList",circulationList);
        return modelAndView;
    }
}
