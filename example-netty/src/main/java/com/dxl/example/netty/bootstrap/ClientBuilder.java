package com.dxl.example.netty.bootstrap;

import com.dxl.example.netty.rpcproxy.RpcProxy;

/**
 * @Program ClientBuilder
 * @Description
 * @Author duxl
 * @Create 2018/11/15 14:46
 */
public class ClientBuilder<T> {
    private String serviceName;
    private String zkConn;
    private Class<T> serviceInterface;
    private int requestTimeoutMills = 10000;
    //private Class<? extends RpcProxy> clientProxyClass = CglibRpcProxy.class;
}
