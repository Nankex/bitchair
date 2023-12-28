package com.example.bitchair.controller;

import com.example.bitchair.entity.Account;
import com.example.bitchair.entity.Block;
import com.example.bitchair.entity.Transaction;
import com.example.bitchair.service.BlockService;
import com.example.bitchair.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/6.
 */
@Controller
public class BlockController {
    @Autowired
    BlockService blockService;
    @Autowired
    TransactionService transactionService;
    @GetMapping("/BlockList")
    public ModelAndView BlockList(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("apps-block-list");
        Account account =(Account) httpSession.getAttribute("account");
        modelAndView.addObject("username",account.getUsername());
        List<Block> blockList = blockService.findAllBlock();
//        System.out.println("blockList = " + blockList);
        modelAndView.addObject("blockList",blockList);
        modelAndView.addObject("count",blockList.size());
        return modelAndView;
    }
    @GetMapping("/ShowBlock")
    public ModelAndView ShowBlock(HttpSession httpSession,HttpServletRequest httpServletRequest){
        ModelAndView modelAndView = new ModelAndView("apps-block-profile");
        Account account =(Account) httpSession.getAttribute("account");
        modelAndView.addObject("username",account.getUsername());
////        System.out.println("account = " + account);
        String id = httpServletRequest.getParameter("height");
        int num = Integer.valueOf(id);
        String previous = String.valueOf(num-1);
        String next = String.valueOf(num+1);
        modelAndView.addObject("current",id);
        modelAndView.addObject("previous",previous);
        modelAndView.addObject("next",next);
        Block block = blockService.findByHeight(id);
        modelAndView.addObject("block",block);
        List<Transaction> transactionList = transactionService.findTransactionById(id);
////        System.out.println("transactionList = " + transactionList);
        modelAndView.addObject("transactionList",transactionList);
        modelAndView.addObject("count",transactionList.size());
        modelAndView.addObject("blockhash",block.getHash());
        return modelAndView;
    }
}
