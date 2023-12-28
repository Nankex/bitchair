package com.example.bitchair.mapper;

import com.example.bitchair.entity.Price;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/16.
 */
@Mapper
@Repository("priceMapper")
public interface PriceMapper {
    List<Price> findAllPrice();
}
