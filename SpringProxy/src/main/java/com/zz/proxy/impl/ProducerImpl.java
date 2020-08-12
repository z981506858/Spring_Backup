package com.zz.proxy.impl;

import com.zz.proxy.IProducer;

/**
 * 生产者
 */
public class ProducerImpl implements IProducer {

    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money) {
        System.out.println("销售产品，拿到"+money+"元");
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(float money) {
        System.out.println("提供售后，并拿到钱"+money);
    }
}
