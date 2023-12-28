package com.example.bitchair.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author nankex.
 * @data 2023/4/16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Price {
    String data;
    String price;
}
