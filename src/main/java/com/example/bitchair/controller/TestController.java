package com.example.bitchair.controller;

import com.example.bitchair.entity.Input;
import com.example.bitchair.entity.Price;
import com.example.bitchair.file.BlockFileLoad;
import com.example.bitchair.service.InputService;
import com.example.bitchair.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.security.PublicKey;
import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/9.
 */
@Controller
public class TestController {
    @Autowired
    PriceService priceService;
    @Autowired
    InputService inputService;
    @GetMapping("/Test")
    public ModelAndView Test(){
        ModelAndView modelAndView = new ModelAndView("index01");
        modelAndView.addObject("num",50);
        List<Price> list = priceService.findAllPrice();
        System.out.println("list = " + list);
        modelAndView.addObject("list",list);
        return modelAndView;
    }
    @GetMapping("/Test01")
    public ModelAndView Test01(){
        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("num",50);
        return modelAndView;
    }
    @GetMapping("/Test03")
    public String testPathVariable(@PathVariable(value = "idd") String id) {
        System.out.println("获取到的id为：" + id);
        return "success";
    }
    @GetMapping("/Test04")
    public String Test04(){
        BlockFileLoad blockFileLoad = new BlockFileLoad();
        blockFileLoad.tess();
        System.out.println("blockFileLoad = " + blockFileLoad);
        return null;
    }
    @GetMapping("/Test05")
    public void Test05(){
        List<Input> inputs = inputService.findByThash("014c8c49e022bf99c470e0182ab9a4752428df121e0739c8c97f5b2d4edd751d");
        System.out.println("inputs = " + inputs);
    }
}
