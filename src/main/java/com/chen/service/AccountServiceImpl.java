package com.chen.service;

import com.chen.dao.AccountMapper;
import com.chen.dao.ProfileMapper;
import com.chen.model.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/16.
 */
@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private AccountMapper dao;
    @Autowired
    private ProfileMapper pdao;
    public Account selectByUsername(Account account) {
        return dao.selectByUsername(account);
    }

    public int insert(Account record) {

        try {
            dao.insert(record);
            pdao.insert(record.getProfile());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
