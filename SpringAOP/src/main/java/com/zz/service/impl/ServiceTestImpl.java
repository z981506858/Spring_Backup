package com.zz.service.impl;

import com.zz.dao.DaoTest;
import com.zz.domain.ServiceDO;
import com.zz.service.IServiceTest;
import com.zz.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ServiceTestImpl implements IServiceTest {

    @Autowired
    private DaoTest daoTest;
    @Autowired
    private TransactionManager transactionManager;

    @Override
    public List<ServiceDO> findAll() {
            return daoTest.findAll();
    }

    @Override
    public ServiceDO findById(Integer id) {
            return daoTest.findById(id);
    }

    @Override
    public void saveService(ServiceDO serviceDO) {
            daoTest.saveService(serviceDO);
    }

    @Override
    public void updateService(ServiceDO serviceDO) {
            daoTest.updateService(serviceDO);
    }

    @Override
    public void deleteService(Integer id) {
            daoTest.deleteService(id);
    }

    /**
     * 转账操作
     * @param name1
     * @param name2
     * @param money
     */
    @Override
    public void transfer(String name1, String name2, Float money) {
            // 查找转出账户
            ServiceDO source = daoTest.findByName(name1);
            // 查找转入账户
            ServiceDO target = daoTest.findByName(name2);
            // 转出减钱
            source.setMoney(source.getMoney() - money);
            // 转入加钱
            target.setMoney(target.getMoney() + money);
            // 更新转出账户
            daoTest.updateService(source);

            /**
             * 经典的1/0问题，违反了事务的原子性
             */
//            int i = 1/0;

            // 更新转入账户
            daoTest.updateService(target);

    }
}
