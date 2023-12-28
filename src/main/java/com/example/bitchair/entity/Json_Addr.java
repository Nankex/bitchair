package com.example.bitchair.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author nankex.
 * @data 2023/5/24.
 */
@NoArgsConstructor
@Data
public class Json_Addr {
    private String hash160;
    private String address;
    private Integer n_tx;
    private Integer n_unredeemed;
    private Long total_received;
    private Long total_sent;
    private Integer final_balance;
    private List<?> txs;
}
