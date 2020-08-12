package com.zz.jdbcTemplate;

import com.zz.dao.AccountDao;
import com.zz.dao.impl.AccountDaoImpl;
import com.zz.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

/**
 * JDBCTemplate的CRUD
 */
public class JDBCTemplate3 {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountDao accountDao = ac.getBean("accountDao", AccountDaoImpl.class);
        Account account = accountDao.findById(1);
        System.out.println(account);

    }
}
