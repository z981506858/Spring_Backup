package com.zz.utils;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;

public class ConnectionUtil {

    private ThreadLocal<Connection> tl = new ThreadLocal<>();

    @Autowired
    private DataSource dataSource;

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThredConnection(){
        try {
            // 先从ThreadLocal上获取
            Connection conn = tl.get();
            // 判断当前线程是否有连接
            if (conn == null){
                // 从数据源中获取一个，并且存入ThreadLocal中
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            // 返回当前线程的连接
            return conn;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void remove(){
        tl.remove();
    }
}
