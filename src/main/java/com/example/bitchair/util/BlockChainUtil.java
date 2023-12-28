package com.example.bitchair.util;

import com.example.bitchair.entity.Json_Addr;
import com.example.bitchair.entity.Json_TransHash;
import com.example.bitchair.entity.Json_blockHash;
import com.example.bitchair.entity.Json_blockHeight;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author nankex.
 * @data 2023/5/24.
 */
public class BlockChainUtil {

//    static {
//        //for localhost testing only
//        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
//                new javax.net.ssl.HostnameVerifier(){
//
//                    public boolean verify(String hostname,
//                                          javax.net.ssl.SSLSession sslSession) {
//                        if (hostname.equals("blockchain.info")) {
//                            return true;
//                        }
//                        return false;
//                    }
//                });
//    }
    public String loadJson (String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"utf-8"));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json.toString();
    }
    public Json_blockHash rawblock(String hash){
        String url = "https://blockchain.info/rawblock/"+hash;
        String json = loadJson(url);
        Json_blockHash jsonblockHash = null;
        try {
            jsonblockHash = new ObjectMapper().readValue(json, Json_blockHash.class);
            System.out.println("jsonblockHash = " + jsonblockHash);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonblockHash;
    }
    public Json_blockHeight getBlockByHeight(String height){
        String url = " https://blockchain.info/block-height/"+height+"?format=json";
        String json = loadJson(url);
        Json_blockHeight json_blockHeight = null;
        try {
            json_blockHeight = new ObjectMapper().readValue(json, Json_blockHeight .class);
            System.out.println("block_blockchain = " + json_blockHeight);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json_blockHeight;
    }
    public Json_TransHash rawtx(String hash){
        String url = " https://blockchain.info/rawtx/"+hash;
        String json = loadJson(url);
        Json_TransHash json_transHash = null;
        try {
            json_transHash = new ObjectMapper().readValue(json, Json_TransHash .class);
            System.out.println("json_transHash = " + json_transHash);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json_transHash;
    }
    public Json_Addr rawaddr(String addr){
        String url = " https://blockchain.info/rawaddr/"+addr+"?limit=50&offset=100";
        String json = loadJson(url);
        Json_Addr json_addr = null;
        try {
            json_addr = new ObjectMapper().readValue(json, Json_Addr .class);
            System.out.println("json_addr = " + json_addr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json_addr;
    }
}
