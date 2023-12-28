package com.example.bitchair.controller;

import com.example.bitchair.entity.Block;
import com.example.bitchair.entity.Power;
import com.example.bitchair.entity.Transaction;
import com.example.bitchair.service.BlockService;
import com.example.bitchair.service.TransactionService;
import com.example.bitchair.util.BlockFileUtil;
import com.example.bitchair.util.DownLoadFromUrlUtil;
import com.example.bitchair.util.FileUtil;
import com.example.bitchair.util.GzUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author nankex.
 * @data 2023/5/18.
 */
@Controller
public class CrawlerController {
    @Autowired
    BlockService blockService;
    @Autowired
    TransactionService transactionService;
    @ApiOperation("爬取Block块信息进行数据分析后转存")
    @PostMapping("/BlockCrawler")
    public ModelAndView BlockCrawler(@RequestParam String date, HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("power-index");
        Power account =(Power) httpSession.getAttribute("account");
        modelAndView.addObject("username",account.getUsername());
        /**
         * 从前端获取日期信息 根据日期信息爬取当天的比特币块信息的tsv.gz文件
         */
        String[] result = date.split("-") ;
        date = result[0]+result[1]+result[2];
        System.out.println("date = " + date);
        String urlStr = "https://gz.blockchair.com/bitcoin/blocks/blockchair_bitcoin_blocks_"+date+".tsv.gz";
        String fileName = "blockchair_bitcoin_blocks_"+date+".tsv.gz";
        String savePath = "E:\\";
        DownLoadFromUrlUtil.downLoadFromUrl(urlStr,fileName,savePath);
        GzUtil.doUncompressFile(savePath+fileName);//解压缩gz文件
        /**
         * 对tsv文件进行sql转化
         */
        fileName = "blockchair_bitcoin_blocks_"+date+".tsv";
        BlockFileUtil blockFileUtil = new BlockFileUtil();
        List<String[]> allRows = blockFileUtil.tes(savePath+fileName);
        Block block = new Block();
        for (int i = 1; i < allRows.size(); i++) {    //忽略第一行
            System.out.println("i = " + i);
            System.out.println(Arrays.asList(allRows.get(i)));
            block.setId(allRows.get(i)[0].trim());
            block.setHash(allRows.get(i)[1].trim());
            block.setTime(allRows.get(i)[2].trim());
            block.setMedian_time(allRows.get(i)[3].trim());
            block.setSize(allRows.get(i)[4].trim());
            block.setStripped_size(allRows.get(i)[5].trim());
            block.setWeight(allRows.get(i)[6].trim());
            block.setVersion(allRows.get(i)[7].trim());
            block.setVersion_hex(allRows.get(i)[8].trim());
            block.setVersion_bits(allRows.get(i)[9].trim());
            block.setMerkle_root(allRows.get(i)[10].trim());
            block.setNonce(allRows.get(i)[11].trim());
            block.setBits(allRows.get(i)[12].trim());
            block.setDifficulty(allRows.get(i)[13].trim());
            block.setChainwork(allRows.get(i)[14].trim());
            block.setCoinbase_data_hex(allRows.get(i)[15].trim());
            block.setTransaction_count(allRows.get(i)[16].trim());
            block.setWitness_count(allRows.get(i)[17].trim());
            block.setInput_count(allRows.get(i)[18].trim());
            block.setOutput_count(allRows.get(i)[19].trim());
            block.setInput_total(allRows.get(i)[20].trim());
            block.setInput_total_usd(allRows.get(i)[21].trim());
            block.setOutput_total(allRows.get(i)[22].trim());
            block.setOutput_total_usd(allRows.get(i)[23].trim());
            block.setFee_total(allRows.get(i)[24].trim());
            block.setFee_total_usd(allRows.get(i)[25].trim());
            block.setFee_per_kb(allRows.get(i)[26].trim());
            block.setFee_per_kb_usd(allRows.get(i)[27].trim());
            block.setFee_per_kwu(allRows.get(i)[28].trim());
            block.setFee_per_kwu_usd(allRows.get(i)[29].trim());
            block.setCdd_total(allRows.get(i)[30].trim());
            block.setGeneration(allRows.get(i)[31].trim());
            block.setGeneration_usd(allRows.get(i)[32].trim());
            block.setReward(allRows.get(i)[33].trim());
            block.setReward_usd(allRows.get(i)[34].trim());
            block.setGuessed_miner(allRows.get(i)[35].trim());
//            System.out.println("block = " + block);
            blockService.saveBlock(block);
        }

        List<Block> blockList = blockService.findAllBlock();
//        System.out.println("blockList = " + blockList);
        modelAndView.addObject("blockList",blockList);
        modelAndView.addObject("count",blockList.size());
        return modelAndView;
    }
    @ApiOperation("爬取Transaction交易信息进行数据分析后转存")
    @PostMapping("/TransactionCrawler")
    public ModelAndView TransactionCrawler(@RequestParam String date, HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        Power account =(Power) httpSession.getAttribute("account");
        modelAndView.addObject("username",account.getUsername());
        /**
         * 从前端获取日期信息 根据日期信息爬取当天的比特币块信息的tsv.gz文件
         */
        String[] result = date.split("-") ;
        date = result[0]+result[1]+result[2];
        System.out.println("date = " + date);
        String urlStr = "https://gz.blockchair.com/bitcoin/transactions/blockchair_bitcoin_transactions_"+date+".tsv.gz";
        String fileName = "blockchair_bitcoin_transactions_"+date+".tsv.gz";
        String savePath = "E:\\";
        DownLoadFromUrlUtil.downLoadFromUrl(urlStr,fileName,savePath);
        GzUtil.doUncompressFile(savePath+fileName);//解压缩gz文件
        fileName = "blockchair_bitcoin_transactions_"+date+".tsv";
        FileUtil fileUtil = new FileUtil();
        List<String[]> allRows = fileUtil.tes(fileName);

        Transaction transaction = new Transaction();
        for (int i = 1; i < allRows.size(); i++) {    //忽略第一行
            System.out.println("i = " + i);
            System.out.println(Arrays.asList(allRows.get(i)));
            transaction.setBlock_id(allRows.get(i)[0].trim());
            transaction.setHash(allRows.get(i)[1].trim());
            transaction.setTime(allRows.get(i)[2].trim());
            transaction.setSize(allRows.get(i)[3].trim());
            transaction.setWeight(allRows.get(i)[4].trim());
            transaction.setVersion(allRows.get(i)[5].trim());
            transaction.setLock_time(allRows.get(i)[6].trim());
            transaction.setIs_coinbase(allRows.get(i)[7].trim());
            transaction.setHas_witness(allRows.get(i)[8].trim());
            transaction.setInput_count(allRows.get(i)[9].trim());
            transaction.setOutput_count(allRows.get(i)[10].trim());
            transaction.setInput_total(allRows.get(i)[11].trim());
            transaction.setInput_total_usd(allRows.get(i)[12].trim());
            transaction.setOutput_total(allRows.get(i)[13].trim());
            transaction.setFee(allRows.get(i)[14].trim());
            transaction.setFee_usd(allRows.get(i)[15].trim());
            transaction.setFee_per_kb(allRows.get(i)[16].trim());
            transaction.setFee_per_kb_usd(allRows.get(i)[17].trim());
            transaction.setFee_per_kwu(allRows.get(i)[18].trim());
            transaction.setFee_per_kwu_usd(allRows.get(i)[19].trim());
            transaction.setCdd_total(allRows.get(i)[20].trim());
            transactionService.saveTransaction(transaction);
        }
        String id = (String) httpSession.getAttribute("height");
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
