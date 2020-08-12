package com.zz.dao;

import com.zz.domain.Account;

/**
 * 数据持久层
 */
public interface AccountDao {
    Account findById(Integer id);

    void updataAccount(Account account);
}
