package com.zz.cglib;

import com.zz.proxy.IProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

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
         *      基于子类的动态代理：
         *          涉及到的类：Enhancer，由第三方cglib库提供
         *      如何创建代理对象：
         *          使用Enhancer类中的create方法
         *      创建要求：被代理类不能是最终类
         *      newProxyInstance()参数：
         *          Class：字节码。用于指定被代理对象的字节码
         *          Callback：用于提供增强的代码，这是在让我写代理方法，此接口的实现类谁调用谁写，一般写的是该接口的子接口实现类 MethodInterceptor()
         */
        ProducerImpl cglibProducer = (ProducerImpl) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             *  作用：执行被代理对象的任何方法都会经过该方法
             * @param proxy
             * @param method
             * @param args
             * 以上三个参数与基于接口的动态代理中invoke方法的参数一样
             * @param methodProxy   当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
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

        cglibProducer.saleProduct(1000f);
    }
}
