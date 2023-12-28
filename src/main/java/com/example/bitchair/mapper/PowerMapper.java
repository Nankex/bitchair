package com.example.bitchair.mapper;

import com.example.bitchair.entity.Account;
import com.example.bitchair.entity.Power;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author nankex.
 * @data 2023/3/17.
 */
@Mapper
@Repository("powerMapper")
public interface PowerMapper {
    Power findByUsername(String username);
}
