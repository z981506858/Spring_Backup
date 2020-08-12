package com.zz.service;

import com.zz.dao.DaoTest;
import com.zz.domain.ServiceDO;

import java.util.List;

public interface IServiceTest {

    List<ServiceDO> findAll();

    ServiceDO findById(Integer id);

    void saveService(ServiceDO serviceDO);

    void updateService(ServiceDO serviceDO);

    void deleteService(Integer id);

    void transfer(String name1, String name2, Float money);

}
