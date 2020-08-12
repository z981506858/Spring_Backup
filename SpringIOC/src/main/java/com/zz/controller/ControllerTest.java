package com.zz.controller;

import com.zz.dao.DaoTest;
import com.zz.service.ServiceTest;
import com.zz.service.impl.ServiceTestImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class ControllerTest {

    public static void main(String[] args) {

//        ServiceTest serviceTest = new ServiceTestImpl();
//        serviceTest.show();
        /**
         * 获取Spring的IOC容器，并根据id来获取对象
         *      ApplicationContext 的三个实现类
         *          ClassPathXmlApplicationContext: 加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话就加载不了
         *          FileSystemXmlApplicationContext: 可以加载磁盘任意路径下的配置文件（必须有访问权限）
         *          AnnotationConfigApplicationContext: 用于读取注解创建容器的内容
         *      核心容器的两个接口引发的问题
         *          1.ApplicationContext：单例对象适用 （日常工作此方法更常用）
         *              在构建核心容器时，创建对象采用的是立即加载的方式。也就是一读取完配置文件就马上创建配置文件中的对象
         *          2.BeanFactory：多例对象适用
         *              在构建核心容器时，创建对象采用的是延迟加载的方式。也就是什么时候根据id获取对象了，才创建对象
         */
        // 1、获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2、根据id获取Bean对象
        ServiceTest serviceTest = (ServiceTest) ac.getBean("accountService");
        DaoTest daoTest = ac.getBean("accountDao",DaoTest.class);

        System.out.println(serviceTest);
        System.out.println(daoTest);

//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory beanFactory = new XmlBeanFactory(resource);
//        ServiceTest test = (ServiceTest) beanFactory.getBean("accountService");

    }
}
