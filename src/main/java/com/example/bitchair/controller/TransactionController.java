package com.example.bitchair.controller;

import com.example.bitchair.entity.Account;
import com.example.bitchair.entity.Block;
import com.example.bitchair.entity.Transaction;
import com.example.bitchair.service.TransactionService;
import com.example.bitchair.util.BlockChainUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/7.
 */
@Controller
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @GetMapping("/TransactionList")
    public ModelAndView TransactionList(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("apps-transactions-list");
        Account account =(Account) httpSession.getAttribute("account");
        modelAndView.addObject("username",account.getUsername());
        List<Transaction> transactionList = transactionService.findAllTransaction();
        modelAndView.addObject("transactionList",transactionList);
        modelAndView.addObject("count",transactionList.size());
        return modelAndView;
    }
    @GetMapping("/ShowTransaction")
    public ModelAndView ShowTransaction(HttpSession httpSession, HttpServletRequest httpServletRequest){
        ModelAndView modelAndView = new ModelAndView("apps-transaction-profile");
        Account account =(Account) httpSession.getAttribute("account");
        modelAndView.addObject("username",account.getUsername());
////        System.out.println("account = " + account);
        String hash = httpServletRequest.getParameter("hash");
        Transaction transaction = transactionService.findByHash(hash);
//        BlockChainUtil blockChainUtil = new BlockChainUtil();
//        blockChainUtil.rawtx(hash);
        int num = Integer.valueOf(transaction.getBlock_id());
        String previous = String.valueOf(num-1);
        String next = String.valueOf(num+1);
        modelAndView.addObject("current",transaction.getBlock_id());
        modelAndView.addObject("previous",previous);
        modelAndView.addObject("next",next);
        modelAndView.addObject("transaction",transaction);
        List<Transaction> transactionList = transactionService.findTransactionById(transaction.getBlock_id());
//        System.out.println("transactionList = " + transactionList);
        modelAndView.addObject("transactionList",transactionList);
        modelAndView.addObject("count",transactionList.size());
        return modelAndView;
    }
}
