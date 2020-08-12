package com.zz.dao.impl;

import com.zz.dao.DaoTest;
import com.zz.domain.Account;
import com.zz.domain.ServiceDO;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

public class DaoTestImpl1 extends JdbcDaoSupport implements DaoTest {

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
