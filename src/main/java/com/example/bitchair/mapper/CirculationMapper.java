package com.example.bitchair.mapper;

import com.example.bitchair.entity.Circulation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nankex.
 * @data 2023/4/17.
 */
@Mapper
@Repository("circulationMapper")
public interface CirculationMapper {
    List<Circulation> findAllCir();
}
