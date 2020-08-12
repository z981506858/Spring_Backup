package com.zz.test;

import com.zz.domain.ServiceDO;
import com.zz.service.IServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml") //获取容器
public class AccountServiceTest {

    @Autowired
    private IServiceTest ist;

    @Test
    public void testTransfer(){
        ist.transfer(1,2,10f);
    }

}
