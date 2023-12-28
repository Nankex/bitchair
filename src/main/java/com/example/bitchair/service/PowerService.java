package com.example.bitchair.service;

import com.example.bitchair.entity.Power;
import com.example.bitchair.mapper.PowerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author nankex.
 * @data 2023/3/17.
 */
@Service
public class PowerService implements PowerMapper {
    @Resource
    PowerMapper powerMapper;
    public Power findByUsername(String username){return powerMapper.findByUsername(username);}
}
