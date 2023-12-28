package com.example.bitchair.controller;

import com.example.bitchair.entity.*;
import com.example.bitchair.service.BlockService;
import com.example.bitchair.service.Collection_BlockService;
import com.example.bitchair.service.Collection_TransactionService;
import com.example.bitchair.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/21.
 */
@Controller
public class CollectionController {
    @Autowired
    Collection_BlockService collection_blockService;
    @Autowired
    Collection_TransactionService collection_transactionService;
    @Autowired
    BlockService blockService;
    @Autowired
    TransactionService transactionService;
    @GetMapping("/SaveCBlock")
    public ModelAndView SaveCBlock(@RequestParam String blockid, HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("apps-block-list");
        Account account = (Account) httpSession.getAttribute("account");
        System.out.println("account = " + account);
        String uid = account.getUsername();
        int flag = 0;
        List<Collection_Block> collection_blockList = collection_blockService.findCBlockByUid(uid);
        Iterator iterator =collection_blockList.listIterator();
        while (iterator.hasNext()){
            Collection_Block collection_block = (Collection_Block) iterator.next();
            if (collection_block.getBlockid()==blockid){
                flag = 1;
            }
        }
        if (flag==0){
            Collection_Block collection_block = new Collection_Block(uid,blockid);
            collection_blockService.saveCollection_Block(collection_block);
        }
        List<Block> blockList = blockService.findAllBlock();
        modelAndView.addObject("blockList",blockList);
        modelAndView.addObject("count",blockList.size());
        return modelAndView;
    }
    @GetMapping("/CancelCBlock")
    public ModelAndView CancelCBlock(@RequestParam String blockid, HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("apps-collection-blocks");
        Account account = (Account) httpSession.getAttribute("account");
        System.out.println("account = " + account);
        String uid = account.getUsername();
        collection_blockService.deleteCBlock(blockid);
        List<Collection_Block> collection_blockList = collection_blockService.findCBlockByUid(account.getUsername());
        Iterator iterator = collection_blockList.listIterator();
        List<Block> blockList= new ArrayList();
        while (iterator.hasNext()){
            Collection_Block c = (Collection_Block) iterator.next();
            Block block = blockService.findByHeight(c.getBlockid());
            blockList.add(block);
        }
        modelAndView.addObject("blockList",blockList);
        modelAndView.addObject("username",account.getUsername());
        modelAndView.addObject("count",blockList.size());
        return modelAndView;
    }
    @GetMapping("/CBlocks")
    public ModelAndView CBlockList(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("apps-collection-blocks");
        Account account = (Account) httpSession.getAttribute("account");
        List<Collection_Block> collection_blockList = collection_blockService.findCBlockByUid(account.getUsername());
        Iterator iterator = collection_blockList.listIterator();
        List<Block> blockList= new ArrayList();
        while (iterator.hasNext()){
            Collection_Block c = (Collection_Block) iterator.next();
            Block block = blockService.findByHeight(c.getBlockid());
            blockList.add(block);
        }
        modelAndView.addObject("blockList",blockList);
        modelAndView.addObject("username",account.getUsername());
        modelAndView.addObject("count",blockList.size());
        return modelAndView;
    }
    @GetMapping("/SaveCTransaction")
    public ModelAndView SaveCTransaction(@RequestParam String hash,@RequestParam String height, HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("apps-block-profile");
        Account account = (Account) httpSession.getAttribute("account");
        String uid = account.getUsername();
        int num = Integer.valueOf(height);
        String previous = String.valueOf(num-1);
        String next = String.valueOf(num+1);
        modelAndView.addObject("current",height);
        modelAndView.addObject("previous",previous);
        modelAndView.addObject("next",next);
        Block block = blockService.findByHeight(height);
        modelAndView.addObject("block",block);
        List<Transaction> transactionList = transactionService.findTransactionById(height);
////        System.out.println("transactionList = " + transactionList);
        modelAndView.addObject("transactionList",transactionList);
        modelAndView.addObject("count",transactionList.size());
        modelAndView.addObject("blockhash",block.getHash());
        int flag = 0;
        List<Collection_Transaction> collection_transactionList = collection_transactionService.findCTransactionByUid(uid);
        Iterator iterator = collection_transactionList.listIterator();
        while (iterator.hasNext()){
            Collection_Transaction collection_transaction = (Collection_Transaction) iterator.next();
            if (collection_transaction.getHash().equals(hash)){
                flag = 1;
            }
        }
        if (flag==0){
            Collection_Transaction collection_transaction = new Collection_Transaction(uid,hash);
            collection_transactionService.saveCollection_Transaction(collection_transaction);
        }
        return modelAndView;
    }
    @GetMapping("/CTransactions")
    public ModelAndView CTransactionList(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("apps-collection-transactions");
        Account account = (Account) httpSession.getAttribute("account");
        List<Collection_Transaction> collection_transactionList = collection_transactionService.findCTransactionByUid(account.getUsername());
        Iterator iterator = collection_transactionList.listIterator();
        List<Transaction> transactionList= new ArrayList();
        while (iterator.hasNext()){
            Collection_Transaction c = (Collection_Transaction) iterator.next();
            Transaction transaction = transactionService.findByHash(c.getHash());
            transactionList.add(transaction);
        }
        modelAndView.addObject("transactionList",transactionList);
        modelAndView.addObject("username",account.getUsername());
        modelAndView.addObject("count",transactionList.size());
        return modelAndView;
    }
    @GetMapping("/CancelCTransaction")
    public ModelAndView CancelCTransaction(@RequestParam String hash, HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("apps-collection-transactions");
        Account account = (Account) httpSession.getAttribute("account");
        System.out.println("account = " + account);
        String uid = account.getUsername();
        collection_transactionService.deleteCTransaction(hash);
        List<Collection_Transaction> collection_transactionList = collection_transactionService.findCTransactionByUid(account.getUsername());
        Iterator iterator = collection_transactionList.listIterator();
        List<Transaction> transactionList= new ArrayList();
        while (iterator.hasNext()){
            Collection_Transaction c = (Collection_Transaction) iterator.next();
            Transaction transaction = transactionService.findByHash(c.getHash());
            transactionList.add(transaction);
        }
        modelAndView.addObject("transactionList",transactionList);
        modelAndView.addObject("username",account.getUsername());
        modelAndView.addObject("count",transactionList.size());
        return modelAndView;
    }
}
