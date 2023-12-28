package com.example.bitchair.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author nankex.
 * @data 2023/3/3.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account extends Power{
    String username;
    String password;
    String email;
}
