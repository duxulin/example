package com.dxl.example.netty.authoritative.guide.p2.aio.server;

public class AsyncTimeServer {

    public static void main(String[] args) {
        int port = 8080;
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }
}



