package com.zz.service.impl;

import com.zz.service.ServiceTest;

import java.util.Date;

/**
 * 成员变量尽量定义在方法中，避免创建对象时变量的多次调用
 */
public class ServiceTestImpl implements ServiceTest {

    private String name;
    private Integer age;
    private Date birthday;

    public ServiceTestImpl(){
        System.out.println("Service 对象被创建了");
    }

    public ServiceTestImpl(String name,Integer age,Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public void show() {
        System.out.println("Service 方法调用"+name+"\t"+age+"\t"+birthday);
    }

}
