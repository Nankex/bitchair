package com.example.bitchair.controller;

import com.example.bitchair.entity.Block;
import com.example.bitchair.entity.Input;
import com.example.bitchair.file.BlockTes;
import com.example.bitchair.service.BlockService;
import com.example.bitchair.service.InputService;
import com.example.bitchair.util.BlockFileUtil;
import com.example.bitchair.util.InputFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/24.
 */
@Controller
public class FileController {
    @Autowired
    BlockService blockService;
    @Autowired
    InputService inputService;
    @GetMapping("/BlockFileReading")
    public void BlockFileReading(){
        BlockFileUtil fileUtil = new BlockFileUtil();
        List<String[]> allRows = fileUtil.tess();
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
            System.out.println("block = " + block);
            blockService.saveBlock(block);
        }
    }
    @GetMapping("/InputFileReading")
    public void InputFileReading(){
        InputFileUtil inputFileUtil = new InputFileUtil();
        List<String[]> allRows = inputFileUtil.tess();
//        System.out.println("allRows = " + allRows);
        Input input = new Input();
        for (int i = 1; i < allRows.size(); i++) {    //忽略第一行
            System.out.println("i = " + i);
            System.out.println(Arrays.asList(allRows.get(i)));
            input.setBlock_id(allRows.get(i)[0].trim());
            input.setTransaction_hash(allRows.get(i)[1].trim());
            input.setIndex(allRows.get(i)[2].trim());
            input.setTime(allRows.get(i)[3].trim());
            input.setValue(allRows.get(i)[4].trim());
            input.setValue_usd(allRows.get(i)[5].trim());
            input.setRecipient(allRows.get(i)[6].trim());
            input.setType(allRows.get(i)[7].trim());
            input.setScript_hex(allRows.get(i)[8].trim());
            input.setIs_from_coinbase(allRows.get(i)[9].trim());
            input.setIs_spendable(allRows.get(i)[10].trim());
            input.setSpending_block_id(allRows.get(i)[11].trim());
            input.setSpending_transaction_hash(allRows.get(i)[12].trim());
            input.setSpending_index(allRows.get(i)[13].trim());
            input.setSpending_time(allRows.get(i)[14].trim());
            input.setSpending_value_usd(allRows.get(i)[15].trim());
            input.setSpending_sequence(allRows.get(i)[16].trim());
            input.setSpending_signature_hex(allRows.get(i)[17].trim());
            input.setSpending_witness(allRows.get(i)[18].trim());
            input.setLifespan(allRows.get(i)[19].trim());
            input.setCdd(allRows.get(i)[20].trim());
            System.out.println("input = " + input);
            inputService.saveInput(input);
        }
    }
}
