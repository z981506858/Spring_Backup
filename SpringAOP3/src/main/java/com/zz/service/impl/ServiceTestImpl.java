package com.zz.service.impl;

import com.zz.dao.DaoTest;
import com.zz.domain.Account;
import com.zz.domain.ServiceDO;
import com.zz.service.IServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "ist")
public class ServiceTestImpl implements IServiceTest {

    @Resource(name = "daoTest")
    private DaoTest daoTest;

    /**
     * 转账操作
     */
    @Override
    public void transfer(Integer id1, Integer id2, Float money) {
            // 查找转出账户
            Account source = daoTest.findById(id1);
            // 查找转入账户
            Account target = daoTest.findById(id2);
            // 转出减钱
            source.setMoney(source.getMoney() - money);
            // 转入加钱
            target.setMoney(target.getMoney() + money);
            // 更新转出账户
            daoTest.updataAccount(source);

            /**
             * 经典的1/0问题，违反了事务的原子性
             */
//            int i = 1/0;

            // 更新转入账户
            daoTest.updataAccount(target);

    }
}
