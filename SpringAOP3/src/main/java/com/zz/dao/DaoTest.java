package com.zz.dao;

import com.zz.domain.Account;
import com.zz.domain.ServiceDO;

import java.util.List;

public interface DaoTest {
    Account findById(Integer id);

    void updataAccount(Account account);
}
