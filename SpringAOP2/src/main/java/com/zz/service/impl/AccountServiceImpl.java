package com.zz.service.impl;

import com.zz.service.IAccountService;
import org.springframework.stereotype.Service;

@Service(value = "accountService")
public class AccountServiceImpl implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("保存方法执行。。。。");
//        int i = 1/0;
    }

    @Override
    public void updateAccount(int id) {
        System.out.println("修改方法执行。。。。");
    }

    @Override
    public int deleteAccount() {
        System.out.println("删除方法执行。。。。");
        return -1;
    }
}
