package com.zz.test;

import com.zz.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        IAccountService ias = (IAccountService) ac.getBean("accountService");

        ias.saveAccount();
    }
}
