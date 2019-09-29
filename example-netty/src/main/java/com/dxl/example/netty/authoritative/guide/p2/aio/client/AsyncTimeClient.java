package com.dxl.example.netty.authoritative.guide.p2.aio.client;

public class AsyncTimeClient {


    public static void main(String[] args) {
        int port = 8080;
        String host = "127.0.0.1";
        new Thread(new AsyncTimeClientHandler(host, port), "AIO-AsyncTimeClientHandler-001").start();
    }
}
