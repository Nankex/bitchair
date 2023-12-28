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
public class Transaction {
    String block_id;
    String hash;
    String time;
    String size;
    String weight;
    String version;
    String lock_time;
    String is_coinbase;
    String has_witness;
    String input_count;
    String output_count;
    String input_total;
    String input_total_usd;
    String output_total;
    String output_total_usd;
    String fee;
    String fee_usd;
    String fee_per_kb;
    String fee_per_kb_usd;
    String fee_per_kwu;
    String fee_per_kwu_usd;
    String cdd_total;
}
