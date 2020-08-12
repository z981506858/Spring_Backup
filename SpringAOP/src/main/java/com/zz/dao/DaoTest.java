package com.zz.dao;

import com.zz.domain.ServiceDO;

import java.util.List;

public interface DaoTest {
    List<ServiceDO> findAll();

    ServiceDO findById(Integer id);

    void saveService(ServiceDO serviceDO);

    void updateService(ServiceDO serviceDO);

    void deleteService(Integer id);

    ServiceDO findByName(String name);
}
