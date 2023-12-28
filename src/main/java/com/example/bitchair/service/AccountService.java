package com.example.bitchair.service;

import com.example.bitchair.entity.Account;
import com.example.bitchair.mapper.AccountMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author nankex.
 * @data 2023/3/3.
 */
@Service
public class AccountService implements AccountMapper{
    @Resource
    AccountMapper accountMapper;
    public Integer saveAccount(Account account){
        return accountMapper.saveAccount(account);
    }
    public Account findByUsername(String username){return accountMapper.findByUsername(username);}
    public Integer resetPassword(Account account){return accountMapper.resetPassword(account);}

}
