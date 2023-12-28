package com.example.bitchair.service;

import com.example.bitchair.entity.Transaction;
import com.example.bitchair.mapper.TransactionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/6.
 */
@Service
public class TransactionService implements TransactionMapper {
    @Resource
    TransactionMapper transactionMapper;
    @Override
    public List<Transaction> findAllTransaction() {
        return transactionMapper.findAllTransaction();
    }

    @Override
    public List<Transaction> findTransactionById(String block_id) {
        return transactionMapper.findTransactionById(block_id);
    }

    @Override
    public Transaction findByHash(String hash) {
        return transactionMapper.findByHash(hash);
    }

    @Override
    public Integer deleteTransaction(Transaction transaction) {
        return transactionMapper.deleteTransaction(transaction);
    }

    @Override
    public Integer saveTransaction(Transaction transaction) {
        return transactionMapper.saveTransaction(transaction);
    }

    @Override
    public Integer updateTransaction(Transaction transaction) {
        return transactionMapper.updateTransaction(transaction);
    }
}
