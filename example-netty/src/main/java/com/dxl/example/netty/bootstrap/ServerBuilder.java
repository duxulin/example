package com.dxl.example.netty.bootstrap;

import com.dxl.example.netty.server.Server;
import com.dxl.example.netty.server.ServerImpl;
import org.springframework.util.Assert;

/**
 * @Program ServerBuilder
 * @Description
 * @Author duxl
 * @Create 2018/11/15 14:34
 */
public class ServerBuilder {

    private int port;
    private String serviceName;
    private Object serviceImpl;
    private String zkConn;

    private ServerBuilder() {
    }

    public static ServerBuilder builder() {
        return new ServerBuilder();
    }

    public Server build() {
        Assert.notNull(serviceImpl, "serviceImpl must be not null");
        Assert.hasText(serviceName, "serviceName must be not null");
        Assert.hasText(zkConn, "zkConn must be not null");
        Assert.state(port > 0, "port must be greate than zero");
        return new ServerImpl(port, serviceImpl, serviceName, zkConn);
    }


    public ServerBuilder port(int port) {
        this.port = port;
        return this;
    }

    public ServerBuilder serviceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public ServerBuilder serviceImpl(Object serviceImpl) {
        this.serviceImpl = serviceImpl;
        return this;
    }

    public ServerBuilder zkConn(String zkConn) {
        this.zkConn = zkConn;
        return this;
    }
}
