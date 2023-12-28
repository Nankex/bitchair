package com.example.bitchair.service;

import com.example.bitchair.entity.Collection_Block;
import com.example.bitchair.mapper.Collection_BlockMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/21.
 */
@Service
public class Collection_BlockService implements Collection_BlockMapper {
    @Resource
    Collection_BlockMapper collection_blockMapper;
    @Override
    public Integer saveCollection_Block(Collection_Block collection_block) {
        return collection_blockMapper.saveCollection_Block(collection_block);
    }

    @Override
    public List<Collection_Block> findCBlockByUid(String uid) {
        return collection_blockMapper.findCBlockByUid(uid);
    }

    @Override
    public Integer deleteCBlock(String blockid) {
        return collection_blockMapper.deleteCBlock(blockid);
    }
}
