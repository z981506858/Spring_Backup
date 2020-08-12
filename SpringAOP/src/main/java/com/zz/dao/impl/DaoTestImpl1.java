package com.zz.dao.impl;

import com.zz.dao.DaoTest;
import com.zz.domain.ServiceDO;
import com.zz.utils.ConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("daoTest")
public class DaoTestImpl1 implements DaoTest {

    @Autowired
    private QueryRunner runner;

    @Autowired
    private ConnectionUtil connectionUtil;

    @Override
    public List<ServiceDO> findAll() {
        try {
            return runner.query(connectionUtil.getThredConnection(),"select * from tests",new BeanListHandler<ServiceDO>(ServiceDO.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ServiceDO findById(Integer id) {
        try {
            return runner.query(connectionUtil.getThredConnection(),"select * from tests where id = ?",new BeanHandler<ServiceDO>(ServiceDO.class),id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveService(ServiceDO serviceDO) {
        try {
            runner.update(connectionUtil.getThredConnection(),"insert into tests(name,money) values (?,?)",serviceDO.getName(), serviceDO.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateService(ServiceDO serviceDO) {
        try {
            runner.update(connectionUtil.getThredConnection(),"update tests set name=?,money=? where id=?",serviceDO.getName(), serviceDO.getMoney(),serviceDO.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteService(Integer id) {
        try {
            runner.update(connectionUtil.getThredConnection(),"delete from tests where id=?",id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ServiceDO findByName(String name) {
        try {
            List<ServiceDO> serviceDOS = runner.query(connectionUtil.getThredConnection(),"select * from tests where name = ?",new BeanListHandler<ServiceDO>(ServiceDO.class),name);
            if (serviceDOS == null || serviceDOS.size() == 0){
                return null;
            }
            if (serviceDOS.size() > 1 ){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            return serviceDOS.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
