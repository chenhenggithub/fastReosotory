package com.chen.service;

import com.chen.model.Account;

/**
 * Created by Administrator on 2017/5/16.
 */
public interface IAccountService {
    public Account selectByUsername(Account account);
    int insert(Account record);
}
