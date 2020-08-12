package com.zz.service.impl;

import com.zz.dao.DaoTest;
import com.zz.service.ServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Date;

/**
 * 曾经的xml配置
 * <bean id="accountService" class="com.zz.service.impl.ServiceTestImpl"
 *      scope="" init-method="" destory-method="">
 *      <property name = "" value = "" / ref = ""></property>
 * </bean>
 *
 * 注解的四大类：
 *      创建对象
 *          @Component
 *          作用：将当前类当作对象存入Spring容器中
 *          属性：value，用于指定bean的id，如果不写时默认值就是当前类的类名且首字母小写
 *          ===============================================================
 *          Controller:多用于控制层
 *          Service：多用于业务层
 *          Repository：多用于持久层
 *          以上三个注解与@Component的功能是一样的
 *      注入数据
 *          @Autowired
 *          作用：自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *              如果IOC容器中没有与要注入的数据匹配的，则注入失败
 *          出现位置：变量上或者方法上
 *          细节：使用注解注入时，Set方法就不是必须的
 *
 *          @Qualifier(value = "")
 *          作用：在按照类注入的基础上再按照名称注入，在给类注入的时候不能单独使用，必须配合@Autowired使用
 *          属性：value，指定bean的名称
 *
 *          @Resource(name = "")
 *          作用：直接按照bean的名称注入，可以单独使用
 *          属性：name，指定bean的名称
 *      修改作用范围
 *          @Scope
 *          作用：用于指定bean的作用范围
 *          属性：value，常用值：singleton、prototype
 *      生命周期（了解）
 *          @PostConstruct
 *          作用：指定初始化方法
 *          @PreDestroy
 *          作用：指定销毁方法
 */
@Service
public class ServiceTestImpl implements ServiceTest {

//    @Autowired
//    @Qualifier(value = "accountDao2")
    @Resource(name = "accountDao1")
    private DaoTest accountDao;

    @PostConstruct
    public void init(){
        System.out.println("初始化成功~~~");
    }

    @PreDestroy
    public void destory(){
        System.out.println("销毁成功~~~");
    }
    @Override
    public void show() {
        accountDao.show();
    }

}
