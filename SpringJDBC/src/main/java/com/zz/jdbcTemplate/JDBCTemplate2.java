package com.zz.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JDBCTemplate的基本用法
 */
public class JDBCTemplate2 {
    public static void main(String[] args) {

        // 准备数据源：Spring内置的数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springtest?serverTimezone=GMT%2B8");
        ds.setUsername("root");
        ds.setPassword("123456");

        // 创建JDBCTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        // 设置数据源
        jdbcTemplate.setDataSource(ds);
        // 执行操作
        jdbcTemplate.execute("insert into tests(name,money) values ('ss',100)");
    }
}
