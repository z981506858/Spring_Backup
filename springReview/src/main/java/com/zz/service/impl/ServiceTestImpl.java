package com.zz.service.impl;

import com.zz.dao.DaoTest;
import com.zz.dao.impl.DaoTestImpl;
import com.zz.factory.BeanFactory;
import com.zz.service.ServiceTest;

/**
 * 成员变量尽量定义在方法中，避免创建对象时变量的多次调用
 */
public class ServiceTestImpl implements ServiceTest {

//    private DaoTest daoTest = new DaoTestImpl();
    private DaoTest daoTest = (DaoTest) BeanFactory.getBean("accountDao");


    @Override
    public void show() {
        //
        int i = 1;
        daoTest.show();
        System.out.println("Service 方法调用");
        System.out.println(i);
        i++;
    }
}
