package com.zz.controller;

import com.zz.factory.BeanFactory;
import com.zz.service.ServiceTest;
import com.zz.service.impl.ServiceTestImpl;

public class ControllerTest {

    public static void main(String[] args) {

//        ServiceTest serviceTest = new ServiceTestImpl();
        for (int i = 0; i < 5; i++) {
            ServiceTest serviceTest = (ServiceTest) BeanFactory.getBean("accountService");
            System.out.println(serviceTest);
            serviceTest.show();
        }
    }
}
