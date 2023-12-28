package com.example.bitchair.mapper;

import com.example.bitchair.entity.Block;
import com.example.bitchair.entity.Transaction;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/6.
 */
@Mapper
@Repository("transactionMapper")
public interface TransactionMapper {
    List<Transaction> findAllTransaction();
    List<Transaction> findTransactionById(String block_id);
    Transaction findByHash(String hash);
    Integer deleteTransaction(Transaction transaction);
    Integer saveTransaction(Transaction transaction);
    Integer updateTransaction(Transaction transaction);
}
