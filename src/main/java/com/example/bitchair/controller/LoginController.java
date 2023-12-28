package com.example.bitchair.controller;

import com.example.bitchair.entity.Account;
import com.example.bitchair.entity.Block;
import com.example.bitchair.entity.Input;
import com.example.bitchair.entity.Power;
import com.example.bitchair.file.InputTes;
import com.example.bitchair.file.tes;
import com.example.bitchair.interceptor.LoginInterceptor;
import com.example.bitchair.service.AccountService;
import com.example.bitchair.service.BlockService;
import com.example.bitchair.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
/**
 * @author nankex.
 * @data 2023/3/3.
 */
public class LoginController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private PowerService powerService;
    @Autowired
    private BlockService blockService;
    @Autowired
    LoginInterceptor loginInterceptor;

    @GetMapping("/Login")
    public ModelAndView Login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
//        InputTes inputTes = new InputTes();
//        inputTes.tess();
        ModelAndView modelAndView = new ModelAndView("auth-login");
        modelAndView.addObject("judge",1);
        return modelAndView;
    }
    @GetMapping("/PLogin")
    public ModelAndView PLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        ModelAndView modelAndView = new ModelAndView("power-login");
        return modelAndView;
    }
    @GetMapping("/Verfiy")
    public ModelAndView Verfiy(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, HttpSession httpSession){
        ModelAndView modelAndView01 = new ModelAndView("apps-block-list");
        ModelAndView modelAndView02 = new ModelAndView("auth-login");
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
//        Object rem = httpServletRequest.getParameter("rem");
//        System.out.println("rem = " + rem);
        Account account = accountService.findByUsername(username);
//        System.out.println("account = " + account);
        if (account.getPassword().equals(password)){
            httpSession.setAttribute("account",account);
            modelAndView01.addObject("username",username);
            List<Block> blockList = blockService.findAllBlock();
//            System.out.println("blockList = " + blockList);
            modelAndView01.addObject("blockList",blockList);
            modelAndView01.addObject("count",blockList.size());
            return modelAndView01;
        }else {
            modelAndView02.addObject("judge",0);
            return modelAndView02;
        }
    }
    @GetMapping("/PVerfiy")
    public ModelAndView PVerfiy(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, HttpSession httpSession){
        ModelAndView modelAndView01 = new ModelAndView("power-index");
        ModelAndView modelAndView02 = new ModelAndView("power-login");
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
//        Object rem = httpServletRequest.getParameter("rem");
//        System.out.println("rem = " + rem);
        Power power = powerService.findByUsername(username);
//        System.out.println("account = " + account);
        if (power.getPassword().equals(password)){
            httpSession.setAttribute("account",power);
            modelAndView01.addObject("username",username);
            List<Block> blockList = blockService.findAllBlock();
//            System.out.println("blockList = " + blockList);
            modelAndView01.addObject("blockList",blockList);
            modelAndView01.addObject("count",blockList.size());
            return modelAndView01;
        }else {
            modelAndView02.addObject("judge",0);
            return modelAndView02;
        }
    }
    @GetMapping("/Loginout")
    public ModelAndView Loginout() {
        ModelAndView modelAndView = new ModelAndView("auth-logout");
        return modelAndView;
    }
    @GetMapping("/Recoverpw")
    public ModelAndView Recoverpw() {
        ModelAndView modelAndView = new ModelAndView("auth-recoverpw");
        modelAndView.addObject("judge",1);
        return modelAndView;
    }
    @GetMapping("/Reset")
    public ModelAndView Reset(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,HttpSession httpSession) {
        ModelAndView modelAndView01 = new ModelAndView("auth-login");
        ModelAndView modelAndView02 = new ModelAndView("auth-recoverpw");
        String username = httpServletRequest.getParameter("username");
        String email = httpServletRequest.getParameter("email");
        String repassword = httpServletRequest.getParameter("repassword");
        Account account = accountService.findByUsername(username);
        if (account.getEmail() == email) {
            account.setPassword(repassword);
            accountService.resetPassword(account);
            return modelAndView01;
        }else {
            modelAndView02.addObject("judge",0);
            return modelAndView02;
        }
    }
}
