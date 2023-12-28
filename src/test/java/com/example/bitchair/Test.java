package com.example.bitchair;

import com.example.bitchair.controller.JsonController;
import com.example.bitchair.entity.Json_blockHash;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author nankex.
 * @data 2023/5/23.
 */
public class Test {
    public static void main(String[] args) {
        JsonController jsonController = new JsonController();
        String json = jsonController.loadJson("https://blockchain.info/rawblock/000000000000000000049a2e7c0f4a2429df7898cbc12d5408ec173698f6cbd8");
        try {
            Json_blockHash jsonblockHash = new ObjectMapper().readValue(json, Json_blockHash.class);
            System.out.println("jsonblockHash = " + jsonblockHash);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
