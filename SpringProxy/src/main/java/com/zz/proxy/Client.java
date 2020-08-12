package com.zz.proxy;

import com.zz.cglib.ProducerImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟消费者
 */
public class Client {
    public static void main(String[] args) {
        ProducerImpl producer = new ProducerImpl();

        /**
         * 动态代理
         *      特点：字节码随用随创建，随用随加载
         *      作用：在不修改源码的基础上对方法增强
         *      分类：
         *          基于接口的动态代理
         *          基于子类的动态代理
         *      基于接口的动态代理：
         *          涉及到的类：Proxy，由JDK官方提供
         *      如何创建代理对象：
         *          使用Proxy类中的newProxyInstance方法
         *      创建要求：被代理类最少实现接口，如果没有则不能使用
         *      newProxyInstance()参数：
         *          ClassLoader：类加载器，用于加载代理对象字节码的。和被代理对象使用相同的类加载器。固定写法 xxx.getClass().getClassLoader()
         *          class[]：字节码数组，用于让代理对象和被代理对象有相同的方法.固定写法 xxx.getClass().getInterfaces()
         *          InvocationHandler：用于提供增强的代码，这是在让我写代理方法，此接口的实现类谁调用谁写
         */
        IProducer proxyProdecer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     *  作用：执行被代理对象的任何方法都会经过该方法
                     * @param proxy     被代理对象的引用
                     * @param method    当前执行的方法
                     * @param args      当前执行所需要的参数
                     * @return          和被代理对象方法有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 提供增强方法
                        Object returnValue = null;
                        // 获取执行方法的参数
                        float money = (float) args[0];
                        // 判断当前方法是不是销售
                        if ("saleProduct".equals(method.getName())){
                            returnValue = method.invoke(producer,money * 0.8f);
                        }
                        return returnValue;
                    }
                });

        proxyProdecer.saleProduct(1000f);
    }
}
