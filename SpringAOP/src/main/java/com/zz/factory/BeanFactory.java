package com.zz.factory;

import com.zz.domain.ServiceDO;
import com.zz.service.IServiceTest;
import com.zz.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象的工厂
 */
public class BeanFactory {

    @Autowired
    @Qualifier(value = "serviceTestImpl")
    private IServiceTest serviceTest;

    @Autowired
    private TransactionManager transactionManager;

    public void setServiceTest(IServiceTest serviceTest) {
        this.serviceTest = serviceTest;
    }

    public IServiceTest getServiceTest(){
        return (IServiceTest) Proxy.newProxyInstance(serviceTest.getClass().getClassLoader(),
                serviceTest.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try {
                            // 开启事务
                            transactionManager.beginTransaction();
                            // 操作
                            rtValue = method.invoke(serviceTest,args);
                            // 提交事务
                            transactionManager.commit();
                            // 返回结果
                            return rtValue;
                        } catch (Exception e){
                            // 回滚
                            transactionManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            // 释放
                            transactionManager.release();
                        }
                    }
                });
    }
}
