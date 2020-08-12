package com.zz.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private static Properties properties;

    /**
     * 为了解决原有工厂模式下的多例问题
     *      就需要创建一个Map，用于存放创建的对象，我们称之为容器
     */
    private static Map<String,Object> beans;

    static {
        try {
            // 实例化对象
            properties = new Properties();
            // 获取Properties文件流
            // 不要 new FileInputStream()
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            // 读取流
            properties.load(in);
            // 实例化容器
            beans = new HashMap<>();
            // 取出配置文件中所有的Key
            Enumeration keys = properties.keys();
            // 遍历枚举
            while (keys.hasMoreElements()){
                // 取出Key
                String key = keys.nextElement().toString();
                // 根据Key获取Value
                String beanPath = properties.getProperty(key);
                // 反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                // 把key和value存入容器中
                beans.put(key,value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据bean的名字来获取bean对象 ==> 单例模式
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

    /**
     * 根据bean的名字来获取bean对象
     * @param beanName
     * @return
     * 存在问题
     *      创建的对象时多例的
     */
//    public static Object getBean(String beanName){
//        Object bean = null;
//
//        try {
//            String beanPath = properties.getProperty(beanName);
//            // 通过反射来完成
//            // newInstance() 每次都会调用默认构造函数创建对象
//            bean = Class.forName(beanPath).newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }
}
