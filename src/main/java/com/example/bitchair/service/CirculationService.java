package com.example.bitchair.service;

import com.example.bitchair.entity.Circulation;
import com.example.bitchair.mapper.CirculationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/17.
 */
@Service
public class CirculationService implements CirculationMapper {
    @Resource
    CirculationMapper circulationMapper;
    @Override
    public List<Circulation> findAllCir() {
        return circulationMapper.findAllCir();
    }
}
