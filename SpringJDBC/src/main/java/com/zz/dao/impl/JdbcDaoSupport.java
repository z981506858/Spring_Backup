package com.zz.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 抽取持久层的重复代码
 */
//public class JdbcDaoSupport {
//    @Resource(name = "jdbcTemplate")
//    private JdbcTemplate jt;
//
//    public void setJt(JdbcTemplate jt) {
//        this.jt = jt;
//    }
//
//    public JdbcTemplate getJt() {
//        return jt;
//    }
//
//    public void setDataSource(DataSource dataSource){
//        if (jt == null){
//            jt = new JdbcTemplate(dataSource);
//        }
//    }
//}
