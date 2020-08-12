package com.zz.dao.impl;

import com.zz.dao.DaoTest;
import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class DaoTestImpl2 implements DaoTest {

    public DaoTestImpl2(){
        System.out.println("Dao2222222222222 对象被创建~~~");
    }
    @Override
    public void show() {
        System.out.println("Dao2222222222222 方法调用");
    }
}
