package com.zz.dao.impl;

import com.zz.dao.AccountDao;
import com.zz.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component(value = "accountDao")
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public Account findById(Integer id) {
        List<Account> accountList = super.getJdbcTemplate().query("select * from tests where id = ?",new BeanPropertyRowMapper<Account>(Account.class),id);
        return accountList.isEmpty() ? null : accountList.get(0);
    }

    @Override
    public void updataAccount(Account account) {
        super.getJdbcTemplate().update("update tests set money = ? where id = ?",account.getMoney(),account.getId());
    }
}
