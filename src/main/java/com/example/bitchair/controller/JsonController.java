package com.example.bitchair.controller;

import com.example.bitchair.entity.Json_blockHash;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author nankex.
 * @data 2023/5/23.
 */
public class JsonController {
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
    public ModelAndView JsonTest(){
        String json = loadJson("https://blockchain.info/rawblock/0000000000000bae09a7a393a8acded75aa67e46cb81f7acaa5ad94f9eacd103");
        try {
            Json_blockHash jsonblockHash = new ObjectMapper().readValue(json, Json_blockHash.class);
            System.out.println("jsonblockHash = " + jsonblockHash);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView  = new ModelAndView();
        return modelAndView;
    }

}
