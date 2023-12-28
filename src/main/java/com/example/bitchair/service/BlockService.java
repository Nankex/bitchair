package com.example.bitchair.service;

import com.example.bitchair.entity.Block;
import com.example.bitchair.mapper.BlockMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/6.
 */
@Service
public class BlockService implements BlockMapper {
    @Resource
    BlockMapper blockMapper;
    @Override
    public List<Block> findAllBlock() {
        return blockMapper.findAllBlock();
    }

    @Override
    public Block findByHeight(String height) {
        return blockMapper.findByHeight(height);
    }

    @Override
    public Integer deleteBlock(Block block) {return blockMapper.deleteBlock(block);}

    @Override
    public Integer saveBlock(Block block) {
        return blockMapper.saveBlock(block);
    }

    @Override
    public Integer updateBlock(Block block) {
        return blockMapper.updateBlock(block);
    }
}
