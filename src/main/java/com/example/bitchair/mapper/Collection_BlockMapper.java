package com.example.bitchair.mapper;

import com.example.bitchair.entity.Collection_Block;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/21.
 */
@Mapper
@Repository("collection_blockMapper")
public interface Collection_BlockMapper {
    Integer saveCollection_Block(Collection_Block collection_block);
    List<Collection_Block> findCBlockByUid(String uid);
    Integer deleteCBlock(String blockid);
}
