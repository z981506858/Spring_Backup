package com.zz.utils;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 事务管理工具类，包含了事务的开启、提交、回滚、释放
 */
public class TransactionManager {

    @Autowired
    private ConnectionUtil connectionUtil;

    /*开启*/
    public void beginTransaction(){
        try {
            connectionUtil.getThredConnection().setAutoCommit(false);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    /*提交*/
    public void commit(){
        try {
            connectionUtil.getThredConnection().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    /*回滚*/
    public void rollback(){
        try {
            connectionUtil.getThredConnection().rollback();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    /*释放*/
    public void release(){
        try {
            // 关闭线程是将其放回线程池中
            connectionUtil.getThredConnection().close();
            connectionUtil.remove();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
