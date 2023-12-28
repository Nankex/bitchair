package com.example.bitchair.service;

import com.example.bitchair.entity.Price;
import com.example.bitchair.mapper.PriceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/16.
 */
@Service
public class PriceService implements PriceMapper{
    @Resource
    PriceMapper priceMapper;

    @Override
    public List<Price> findAllPrice() {
        return priceMapper.findAllPrice();
    }
}
