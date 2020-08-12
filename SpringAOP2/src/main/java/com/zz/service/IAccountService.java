package com.zz.service;

/**
 * 模拟一个业务层接口
 */
public interface IAccountService {

    void saveAccount();

    void updateAccount(int id);

    int deleteAccount();
}
