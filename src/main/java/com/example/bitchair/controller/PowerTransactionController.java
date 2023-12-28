package com.example.bitchair.controller;

import com.example.bitchair.entity.Account;
import com.example.bitchair.entity.Block;
import com.example.bitchair.entity.Power;
import com.example.bitchair.entity.Transaction;
import com.example.bitchair.service.BlockService;
import com.example.bitchair.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/24.
 */
@Controller
public class PowerTransactionController {
    @Autowired
    TransactionService transactionService;
    @Autowired
    BlockService blockService;
    @GetMapping("/PTransactionAdd")
    public ModelAndView PTransactionAdd(HttpSession httpSession,@RequestParam String height){
        ModelAndView modelAndView = new ModelAndView("power-transaction-save");
        Power account =(Power) httpSession.getAttribute("account");
        modelAndView.addObject("username",account.getUsername());
        httpSession.setAttribute("pheight",height);
        return modelAndView;
    }
    @GetMapping("/SubmitPTransactionSave")
    public ModelAndView SubmitPTransactionSave(HttpSession httpSession,HttpServletRequest httpServletRequest){
        ModelAndView modelAndView = new ModelAndView("power-block-profile");
        Power account =(Power) httpSession.getAttribute("account");
        modelAndView.addObject("username",account.getUsername());
        String id =(String) httpSession.getAttribute("pheight");
        System.out.println("id = " + id);
        Transaction transaction = new Transaction();
        transaction.setBlock_id(httpServletRequest.getParameter("block_id"));
        transaction.setHash(httpServletRequest.getParameter("hash"));
        transaction.setTime(httpServletRequest.getParameter("time"));
        transaction.setSize(httpServletRequest.getParameter("size"));
        transaction.setWeight(httpServletRequest.getParameter("weight"));
        transaction.setVersion(httpServletRequest.getParameter("version"));
        transaction.setLock_time(httpServletRequest.getParameter("lock_time"));
        transaction.setIs_coinbase(httpServletRequest.getParameter("is_coinbase"));
        transaction.setHas_witness(httpServletRequest.getParameter("has_witness"));
        transaction.setInput_count(httpServletRequest.getParameter("input_count"));
        transaction.setOutput_count(httpServletRequest.getParameter("output_count"));
        transaction.setInput_total(httpServletRequest.getParameter("input_total"));
        transaction.setInput_total_usd(httpServletRequest.getParameter("input_total_usd"));
        transaction.setOutput_total(httpServletRequest.getParameter("output_total"));
        transaction.setOutput_total_usd(httpServletRequest.getParameter("output_total_usd"));
        transaction.setFee(httpServletRequest.getParameter("fee"));
        transaction.setFee_usd(httpServletRequest.getParameter("fee_usd"));
        transaction.setFee_per_kb(httpServletRequest.getParameter("fee_per_kb"));
        transaction.setFee_per_kb_usd(httpServletRequest.getParameter("fee_per_kb_usd"));
        transaction.setFee_per_kwu(httpServletRequest.getParameter("fee_per_kwu"));
        transaction.setFee_per_kwu_usd(httpServletRequest.getParameter("fee_per_kwu_usd"));
        transaction.setCdd_total(httpServletRequest.getParameter("cdd_total"));
        transactionService.saveTransaction(transaction);
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
    @GetMapping("/PTransactionDelete")
    public ModelAndView PTransactionDelete(HttpSession httpSession, @RequestParam String hash){
        ModelAndView modelAndView = new ModelAndView("power-block-profile");
        Transaction transaction = transactionService.findByHash(hash);
        transactionService.deleteTransaction(transaction);
        Power account =(Power) httpSession.getAttribute("account");
        modelAndView.addObject("username",account.getUsername());
////        System.out.println("account = " + account);
        String id =transaction.getBlock_id();
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
    @GetMapping("/PTransactionUpdate")
    public ModelAndView PTransactionUpdate(HttpSession httpSession,@RequestParam String hash){
        ModelAndView modelAndView = new ModelAndView("power-transaction-update");
        Power account =(Power) httpSession.getAttribute("account");
        modelAndView.addObject("username",account.getUsername());
////        System.out.println("account = " + account);
        Transaction transaction = transactionService.findByHash(hash);
        modelAndView.addObject("transaction",transaction);
        return modelAndView;
    }
    @GetMapping("/SubmitPTransactionUpdate")
    public ModelAndView SubmitPTransactionUpdate(HttpSession httpSession, HttpServletRequest httpServletRequest){
        ModelAndView modelAndView = new ModelAndView("power-block-profile");
        Power account =(Power) httpSession.getAttribute("account");
        modelAndView.addObject("username",account.getUsername());
        //保存Transaction
        Transaction transaction = new Transaction();
        transaction.setBlock_id(httpServletRequest.getParameter("block_id"));
        transaction.setHash(httpServletRequest.getParameter("hash"));
        transaction.setTime(httpServletRequest.getParameter("time"));
        transaction.setSize(httpServletRequest.getParameter("size"));
        transaction.setWeight(httpServletRequest.getParameter("weight"));
        transaction.setVersion(httpServletRequest.getParameter("version"));
        transaction.setLock_time(httpServletRequest.getParameter("lock_time"));
        transaction.setIs_coinbase(httpServletRequest.getParameter("is_coinbase"));
        transaction.setHas_witness(httpServletRequest.getParameter("has_witness"));
        transaction.setInput_count(httpServletRequest.getParameter("input_count"));
        transaction.setOutput_count(httpServletRequest.getParameter("output_count"));
        transaction.setInput_total(httpServletRequest.getParameter("input_total"));
        transaction.setInput_total_usd(httpServletRequest.getParameter("input_total_usd"));
        transaction.setOutput_total(httpServletRequest.getParameter("output_total"));
        transaction.setOutput_total_usd(httpServletRequest.getParameter("output_total_usd"));
        transaction.setFee(httpServletRequest.getParameter("fee"));
        transaction.setFee_usd(httpServletRequest.getParameter("fee_usd"));
        transaction.setFee_per_kb(httpServletRequest.getParameter("fee_per_kb"));
        transaction.setFee_per_kb_usd(httpServletRequest.getParameter("fee_per_kb_usd"));
        transaction.setFee_per_kwu(httpServletRequest.getParameter("fee_per_kwu"));
        transaction.setFee_per_kwu_usd(httpServletRequest.getParameter("fee_per_kwu_usd"));
        transaction.setCdd_total(httpServletRequest.getParameter("cdd_total"));
        transactionService.saveTransaction(transaction);
        String id =transaction.getBlock_id();
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
