package com.dxl.example.examplemybatis;

import org.springframework.jdbc.datasource.ConnectionProxy;

import java.sql.Connection;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Program ConnectionPool
 * @Description
 * @Author duxl
 * @Create 2018/11/12 14:36
 */
public class ConnectionPool {

    private static int count;
    private static Queue<Connection> pool = new ArrayDeque<>();
    private static final int MAX_POOL_SIZE = 10;


    private ConnectionPool() {

    }

    public void addConnection() {
        pool.add(JDBCUtil.getConnection());
    }

    public static synchronized Connection getConnection() {
        if (pool.peek() != null) {
            return pool.poll();
        }
        return JDBCUtil.getConnection();
    }

    public static void release(Connection connection) {
        pool.add(connection);
    }

}
