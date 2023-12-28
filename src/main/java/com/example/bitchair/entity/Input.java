package com.example.bitchair.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author nankex.
 * @data 2023/4/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Input {
    String block_id;
    String transaction_hash;
    String index;
    String time;
    String value;
    String value_usd;
    String recipient;
    String type;
    String script_hex;
    String is_from_coinbase;
    String is_spendable;
    String spending_block_id;
    String spending_transaction_hash;
    String spending_index;
    String spending_time;
    String spending_value_usd;
    String spending_sequence;
    String spending_signature_hex;
    String spending_witness;
    String lifespan;
    String cdd;
}
