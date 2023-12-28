package com.example.bitchair;

import com.example.bitchair.util.TestUtil;

/**
 * @author nankex.
 * @data 2023/5/24.
 */
public class Test05 {
    public static void main(String[] args) {
        TestUtil.httpGet("https://blockchain.info/rawblock");
    }
}
