package com.example.bitchair.service;

import com.example.bitchair.entity.Collection_Block;
import com.example.bitchair.entity.Collection_Transaction;
import com.example.bitchair.mapper.Collection_TransactionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/21.
 */
@Service
public class Collection_TransactionService implements Collection_TransactionMapper{
    @Resource
    Collection_TransactionMapper collection_transactionMapper;

    @Override
    public Integer saveCollection_Transaction(Collection_Transaction collection_transaction) {
        return collection_transactionMapper.saveCollection_Transaction(collection_transaction);
    }

    @Override
    public List<Collection_Transaction> findCTransactionByUid(String uid) {
        return collection_transactionMapper.findCTransactionByUid(uid);
    }

    @Override
    public Integer deleteCTransaction(String hash) {
        return collection_transactionMapper.deleteCTransaction(hash);
    }
}
