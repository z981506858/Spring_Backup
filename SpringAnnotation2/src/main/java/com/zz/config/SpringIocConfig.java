package com.zz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 一个配置类和bean.xml的作用一样
 * @Configuration
 *      作用：指定该类是配置类
 * @ComponentScan()
 *      作用：指定Spring容器创建时要扫描的包
 *      属性：value，单个配置时可以省略
 * @Bean
 *      作用：将当前方法的返回值当作bean对象放进Spring容器中
 *      属性：name，指定bean的id，默认是方法名
 * @Import()
 *      作用：导入其他配置类
 *      细节：有@Import注解的就是主配置类，导入的类则是子配置类
 * @PropertySource()
 *      作用：指定properties文件的位置
 *      属性：value，文件的名称和路径
 *          关键子：classpath，表示类路径下
 */
@Configuration
@ComponentScan("com.zz")

public class SpringIocConfig {

}
