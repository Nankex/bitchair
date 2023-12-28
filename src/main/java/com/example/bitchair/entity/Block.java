package com.example.bitchair.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author nankex.
 * @data 2023/4/6.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Block {
    String id;//height
    String hash;
    String time;
    String median_time;
    String size;
    String stripped_size;
    String weight;
    String version;
    String version_hex;
    String version_bits;
    String merkle_root;
    String nonce;
    String bits;
    String difficulty;
    String chainwork;
    String coinbase_data_hex;
    String transaction_count;
    String witness_count;
    String input_count;
    String output_count;
    String input_total;
    String input_total_usd;
    String output_total;
    String output_total_usd;
    String fee_total;
    String fee_total_usd;
    String fee_per_kb;
    String fee_per_kb_usd;
    String fee_per_kwu;
    String fee_per_kwu_usd;
    String cdd_total;
    String generation;
    String generation_usd;
    String reward;
    String reward_usd;
    String guessed_miner;
}
