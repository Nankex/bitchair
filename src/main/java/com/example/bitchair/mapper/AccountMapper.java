package com.example.bitchair.mapper;

import com.example.bitchair.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author nankex.
 * @data 2023/3/3.
 */
@Mapper
@Repository("accountMapper")
public interface AccountMapper {
    Integer saveAccount(Account account);
    Account findByUsername(String username);
    Integer resetPassword(Account account);
}
