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
 * @data 2023/4/22.
 */
@Controller
public class PowerBlockController {
    @Autowired
    BlockService blockService;
    @Autowired
    TransactionService transactionService;
    @GetMapping("/PBlockList")
    public ModelAndView PBlockList(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("power-index");
        Power account =(Power) httpSession.getAttribute("account");
        modelAndView.addObject("username",account.getUsername());
        List<Block> blockList = blockService.findAllBlock();
//        System.out.println("blockList = " + blockList);
        modelAndView.addObject("blockList",blockList);
        modelAndView.addObject("count",blockList.size());
        return modelAndView;
    }
    @GetMapping("/PBlockSave")
    public ModelAndView PBlockSave(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("power-block-save");
        Power account =(Power) httpSession.getAttribute("account");
        modelAndView.addObject("username",account.getUsername());
        return modelAndView;
    }
    @GetMapping("/PBlockAdd")
    public ModelAndView PBlockAdd(HttpSession httpSession,HttpServletRequest httpServletRequest){
        ModelAndView modelAndView = new ModelAndView("power-index");
        Power account =(Power) httpSession.getAttribute("account");
        modelAndView.addObject("username",account.getUsername());
        Block block = new Block();
        block.setId(httpServletRequest.getParameter("id"));
        System.out.println("block = " + block);
        block.setHash(httpServletRequest.getParameter("hash"));
        block.setTime(httpServletRequest.getParameter("time"));
        block.setMedian_time(httpServletRequest.getParameter("median_time"));
        block.setSize(httpServletRequest.getParameter("size"));
        block.setStripped_size(httpServletRequest.getParameter("stripped_size"));
        block.setWeight(httpServletRequest.getParameter("weight"));
        block.setVersion(httpServletRequest.getParameter("version"));
        block.setVersion_hex(httpServletRequest.getParameter("version_hex"));
        block.setVersion_bits(httpServletRequest.getParameter("version_bits"));
        block.setMerkle_root(httpServletRequest.getParameter("merkle_root"));
        block.setNonce(httpServletRequest.getParameter("nonce"));
        block.setBits(httpServletRequest.getParameter("bits"));
        block.setDifficulty(httpServletRequest.getParameter("difficulty"));
        block.setChainwork(httpServletRequest.getParameter("chainwork"));
        block.setCoinbase_data_hex(httpServletRequest.getParameter("coinbase_data_hex"));
        block.setTransaction_count(httpServletRequest.getParameter("transaction_count"));
        block.setWitness_count(httpServletRequest.getParameter("witness_count"));
        block.setInput_count(httpServletRequest.getParameter("input_count"));
        block.setOutput_count(httpServletRequest.getParameter("output_count"));
        block.setInput_total(httpServletRequest.getParameter("input_total"));
        block.setInput_total_usd(httpServletRequest.getParameter("input_total_usd"));
        block.setOutput_total(httpServletRequest.getParameter("output_total"));
        block.setOutput_total_usd(httpServletRequest.getParameter("output_total_usd"));
        block.setFee_total(httpServletRequest.getParameter("fee_total"));
        block.setFee_total_usd(httpServletRequest.getParameter("fee_total_usd"));
        block.setFee_per_kb(httpServletRequest.getParameter("fee_per_kb"));
        block.setFee_per_kb_usd(httpServletRequest.getParameter("fee_per_kb_usd"));
        block.setFee_per_kwu(httpServletRequest.getParameter("fee_per_kwu"));
        block.setFee_per_kwu_usd(httpServletRequest.getParameter("fee_per_kwu_usd"));
        block.setCdd_total(httpServletRequest.getParameter("cdd_total"));
        block.setGeneration(httpServletRequest.getParameter("generation"));
        block.setGeneration_usd(httpServletRequest.getParameter("generation_usd"));
        block.setReward(httpServletRequest.getParameter("reward"));
        block.setReward_usd(httpServletRequest.getParameter("reward_usd"));
        block.setGuessed_miner(httpServletRequest.getParameter("guessed_miner"));
        blockService.saveBlock(block);
        List<Block> blockList = blockService.findAllBlock();
//        System.out.println("blockList = " + blockList);
        modelAndView.addObject("blockList",blockList);
        modelAndView.addObject("count",blockList.size());
        return modelAndView;
    }
    @GetMapping("/PBlockDelete")
    public ModelAndView PBlockDelete(@RequestParam String height, HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("power-index");
        Power account =(Power) httpSession.getAttribute("account");
        modelAndView.addObject("username",account.getUsername());
        Block block = blockService.findByHeight(height);
        blockService.deleteBlock(block);
        List<Block> blockList = blockService.findAllBlock();
//        System.out.println("blockList = " + blockList);
        modelAndView.addObject("blockList",blockList);
        modelAndView.addObject("count",blockList.size());
        return modelAndView;
    }
    @GetMapping("/PBlockUpdate")
    public ModelAndView PBlockUpdate(HttpSession httpSession,@RequestParam String height){
        ModelAndView modelAndView = new ModelAndView("power-block-update");
        Power account =(Power) httpSession.getAttribute("account");
        modelAndView.addObject("username",account.getUsername());
        Block block = blockService.findByHeight(height);
        modelAndView.addObject("block",block);
        return modelAndView;
    }
    @GetMapping("/SubmitPBlockUpdate")
    public ModelAndView SubmitPBlockUpdate(HttpSession httpSession, HttpServletRequest httpServletRequest){
        ModelAndView modelAndView = new ModelAndView("power-index");
        Power account =(Power) httpSession.getAttribute("account");
        modelAndView.addObject("username",account.getUsername());
        Block block = new Block();
        block.setId(httpServletRequest.getParameter("id"));
        block.setHash(httpServletRequest.getParameter("hash"));
        block.setTime(httpServletRequest.getParameter("time"));
        block.setMedian_time(httpServletRequest.getParameter("median_time"));
        block.setSize(httpServletRequest.getParameter("size"));
        block.setStripped_size(httpServletRequest.getParameter("stripped_size"));
        block.setWeight(httpServletRequest.getParameter("weight"));
        block.setVersion(httpServletRequest.getParameter("version"));
        block.setVersion_hex(httpServletRequest.getParameter("version_hex"));
        block.setVersion_bits(httpServletRequest.getParameter("version_bits"));
        block.setMerkle_root(httpServletRequest.getParameter("merkle_root"));
        block.setNonce(httpServletRequest.getParameter("nonce"));
        block.setBits(httpServletRequest.getParameter("bits"));
        block.setDifficulty(httpServletRequest.getParameter("difficulty"));
        block.setChainwork(httpServletRequest.getParameter("chainwork"));
        block.setCoinbase_data_hex(httpServletRequest.getParameter("coinbase_data_hex"));
        block.setTransaction_count(httpServletRequest.getParameter("transaction_count"));
        block.setWitness_count(httpServletRequest.getParameter("witness_count"));
        block.setInput_count(httpServletRequest.getParameter("input_count"));
        block.setOutput_count(httpServletRequest.getParameter("output_count"));
        block.setInput_total(httpServletRequest.getParameter("input_total"));
        block.setInput_total_usd(httpServletRequest.getParameter("input_total_usd"));
        block.setOutput_total(httpServletRequest.getParameter("output_total"));
        block.setOutput_total_usd(httpServletRequest.getParameter("output_total_usd"));
        block.setFee_total(httpServletRequest.getParameter("fee_total"));
        block.setFee_total_usd(httpServletRequest.getParameter("fee_total_usd"));
        block.setFee_per_kb(httpServletRequest.getParameter("fee_per_kb"));
        block.setFee_per_kb_usd(httpServletRequest.getParameter("fee_per_kb_usd"));
        block.setFee_per_kwu(httpServletRequest.getParameter("fee_per_kwu"));
        block.setFee_per_kwu_usd(httpServletRequest.getParameter("fee_per_kwu_usd"));
        block.setCdd_total(httpServletRequest.getParameter("cdd_total"));
        block.setGeneration(httpServletRequest.getParameter("generation"));
        block.setGeneration_usd(httpServletRequest.getParameter("generation_usd"));
        block.setReward(httpServletRequest.getParameter("reward"));
        block.setReward_usd(httpServletRequest.getParameter("reward_usd"));
        block.setGuessed_miner(httpServletRequest.getParameter("guessed_miner"));
        blockService.updateBlock(block);
        List<Block> blockList = blockService.findAllBlock();
//        System.out.println("blockList = " + blockList);
        modelAndView.addObject("blockList",blockList);
        modelAndView.addObject("count",blockList.size());
        return modelAndView;
    }

    @GetMapping("/ShowPBlock")
    public ModelAndView ShowBlock(HttpSession httpSession,HttpServletRequest httpServletRequest){
        ModelAndView modelAndView = new ModelAndView("power-block-profile");
        Power account =(Power) httpSession.getAttribute("account");
        modelAndView.addObject("username",account.getUsername());
////        System.out.println("account = " + account);
        String id = httpServletRequest.getParameter("height");
        httpSession.setAttribute("height",id);
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
