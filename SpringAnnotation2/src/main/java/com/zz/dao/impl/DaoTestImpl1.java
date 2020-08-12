package com.zz.dao.impl;

import com.zz.dao.DaoTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("accountDao1")
public class DaoTestImpl1 implements DaoTest {

    public DaoTestImpl1(){
        System.out.println("Dao11111111111111 对象被创建~~~");
    }
    @Override
    public void show() {
        System.out.println("Dao1111111111111 方法调用");
    }
}
