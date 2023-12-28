package com.example.bitchair.mapper;

import com.example.bitchair.entity.Block;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/6.
 */
@Mapper
@Repository("blockMapper")
public interface BlockMapper {
    List<Block> findAllBlock();
    Block findByHeight(String height);
    Integer deleteBlock(Block block);
    Integer saveBlock(Block block);
    Integer updateBlock(Block block);
}
