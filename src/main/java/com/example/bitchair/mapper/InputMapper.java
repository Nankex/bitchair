package com.example.bitchair.mapper;

import com.example.bitchair.entity.Input;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/17.
 */
@Mapper
@Repository("inputMapper")
public interface InputMapper {
    Integer saveInput(Input input);
    List<Input> findByThash(String hash);
}
