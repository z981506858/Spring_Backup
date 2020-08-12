package com.zz.test;

import com.zz.domain.ServiceDO;
import com.zz.service.IServiceTest;
import com.zz.service.impl.ServiceTestImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml") //获取容器
public class AccountServiceTest {

    @Autowired
    @Qualifier("proxyAccountService")
    private IServiceTest ist;

    @Test
    public void testFindAll(){
        List<ServiceDO> serviceDOS = ist.findAll();
        for (ServiceDO e : serviceDOS){
            System.out.println(e);
        }
    }

    @Test
    public void testTransfer(){
        ist.transfer("zz","cr",10f);
    }

}
