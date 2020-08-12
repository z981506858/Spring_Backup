package com.zz.controller;

import com.zz.dao.DaoTest;
import com.zz.service.ServiceTest;
import com.zz.service.impl.ServiceTestImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ControllerTest {

    public static void main(String[] args) {

//        ServiceTest serviceTest = new ServiceTestImpl();
//        serviceTest.show();

        // 1、获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2、根据id获取Bean对象
        ServiceTest serviceTest = (ServiceTest) ac.getBean("accountService");
        ServiceTest serviceTest2 = (ServiceTest) ac.getBean("accountService");

//        serviceTest.show();
        System.out.println(serviceTest == serviceTest2);

    }
}
