package com.example.bitchair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class BitchairApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitchairApplication.class, args);
    }

}
