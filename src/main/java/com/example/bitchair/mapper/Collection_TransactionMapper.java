package com.example.bitchair.mapper;

import com.example.bitchair.entity.Collection_Block;
import com.example.bitchair.entity.Collection_Transaction;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/21.
 */
@Mapper
@Repository("collection_TransactionMapper")
public interface Collection_TransactionMapper {
    Integer saveCollection_Transaction(Collection_Transaction collection_transaction);
    List<Collection_Transaction> findCTransactionByUid(String uid);
    Integer deleteCTransaction(String hash);
}
