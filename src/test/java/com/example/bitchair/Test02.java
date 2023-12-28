package com.example.bitchair;

import com.example.bitchair.entity.Json_blockHeight;
import com.example.bitchair.util.BlockChainUtil;

/**
 * @author nankex.
 * @data 2023/5/24.
 */
public class Test02 {
    public static void main(String[] args) {
        BlockChainUtil blockChainUtil = new BlockChainUtil();
        Json_blockHeight json_blockHeight = blockChainUtil.getBlockByHeight("783816");
        System.out.println("block_blockchain = " + json_blockHeight);
    }
}
