package com.zz.controller;

import com.zz.service.IServiceTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ControllerTest {

    public static void main(String[] args) {

        // 1、获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2、根据id获取Bean对象
        IServiceTest serviceTest = (IServiceTest) ac.getBean("serviceTestImpl");
    }
}
