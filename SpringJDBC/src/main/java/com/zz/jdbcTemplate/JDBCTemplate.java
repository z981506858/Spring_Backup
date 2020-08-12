package com.zz.jdbcTemplate;

import com.zz.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

/**
 * JDBCTemplate的CRUD
 */
public class JDBCTemplate {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
//        jt.execute("insert into tests(name,money) values ('ff',100)");

        // 保存
//        jt.update("insert into tests(name,money) values (?,?)","rr",200f);
        // 更新
//        jt.update("update tests set money = ? where id = ?",1000f,1);
        // 删除
//        jt.update("delete from test where id = ?",3);
        // 查询所有
        // 利用Spring自带的 BeanPropertyRowMapper 来完成数据封装
//        List<Account> accountList = jt.query("select * from tests",new BeanPropertyRowMapper<Account>(Account.class));
//        for (Account e : accountList){
//            System.out.println(e);
//        }
        // 查询一个
//        List<Account> accountList = jt.query("select * from tests where id = ?",new BeanPropertyRowMapper<Account>(Account.class),1);
//        System.out.println(accountList.get(0));
        // 查询一行一列
        int i = jt.queryForObject("select count(*) from tests where money > ?",Integer.class,100f);
        System.out.println(i);

    }
}
