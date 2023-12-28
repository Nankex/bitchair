package com.example.bitchair.service;

import com.example.bitchair.entity.Input;
import com.example.bitchair.mapper.InputMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/17.
 */
@Service
public class InputService implements InputMapper {
    @Resource
    InputMapper inputMapper;
    @Override
    public Integer saveInput(Input input) {
        return inputMapper.saveInput(input);
    }

    @Override
    public List<Input> findByThash(String hash) {
        return inputMapper.findByThash(hash);
    }
}
