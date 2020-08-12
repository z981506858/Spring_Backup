package com.zz.factory;

import com.zz.service.ServiceTest;
import com.zz.service.impl.ServiceTestImpl;

/**
 * 模拟一个工厂类方法，创建对象
 */
public class InstanceFactory {

    public ServiceTest getService(){
        return new ServiceTestImpl();
    }
}
