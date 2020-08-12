package com.zz.service.impl;

import com.zz.dao.DaoTest;
import com.zz.domain.ServiceDO;
import com.zz.service.IServiceTest;
import com.zz.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTestImpl_Old implements IServiceTest {

    @Autowired
    private DaoTest daoTest;
    @Autowired
    private TransactionManager transactionManager;

    @Override
    public List<ServiceDO> findAll() {
        try {
            // 开启事务
            transactionManager.beginTransaction();
            // 操作
            List<ServiceDO> serviceDOS = daoTest.findAll();
            // 提交事务
            transactionManager.commit();
            // 返回结果
            return serviceDOS;
        } catch (Exception e){
            // 回滚
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 释放
            transactionManager.rollback();
        }

    }

    @Override
    public ServiceDO findById(Integer id) {
        try {
            // 开启事务
            transactionManager.beginTransaction();
            // 操作
            ServiceDO serviceDO = daoTest.findById(id);
            // 提交事务
            transactionManager.commit();
            // 返回结果
            return serviceDO;
        } catch (Exception e){
            // 回滚
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 释放
            transactionManager.rollback();
        }

    }

    @Override
    public void saveService(ServiceDO serviceDO) {
        try {
            // 开启事务
            transactionManager.beginTransaction();
            // 操作
            daoTest.saveService(serviceDO);
            // 提交事务
            transactionManager.commit();
        } catch (Exception e){
            // 回滚
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 释放
            transactionManager.rollback();
        }

    }

    @Override
    public void updateService(ServiceDO serviceDO) {
        try {
            // 开启事务
            transactionManager.beginTransaction();
            // 操作
            daoTest.updateService(serviceDO);
            // 提交事务
            transactionManager.commit();
        } catch (Exception e){
            // 回滚
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 释放
            transactionManager.rollback();
        }

    }

    @Override
    public void deleteService(Integer id) {
        try {
            // 开启事务
            transactionManager.beginTransaction();
            // 操作
            daoTest.deleteService(id);
            // 提交事务
            transactionManager.commit();
        } catch (Exception e){
            // 回滚
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 释放
            transactionManager.rollback();
        }

    }

    /**
     * 转账操作
     * @param name1
     * @param name2
     * @param money
     */
    @Override
    public void transfer(String name1, String name2, Float money) {
        try {
            // 开启事务
            transactionManager.beginTransaction();

            // 操作
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
            int i = 1/0;

            // 更新转入账户
            daoTest.updateService(target);
            // 提交事务
            transactionManager.commit();
        } catch (Exception e){
            // 回滚
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 释放
            transactionManager.rollback();
        }

    }
}
