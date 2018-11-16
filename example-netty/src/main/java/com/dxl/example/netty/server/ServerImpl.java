package com.dxl.example.netty.server;

import com.dxl.example.netty.protocol.RpcDecoder;
import com.dxl.example.netty.protocol.RpcEncoder;
import com.dxl.example.netty.utils.Constant;
import com.dxl.example.netty.utils.NetUtils;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Program ServerImpl
 * @Description
 * @Author duxl
 * @Create 2018/11/15 13:46
 */
public class ServerImpl implements Server {

    private static final Logger LOG = LoggerFactory.getLogger(ServerImpl.class);

    private String localIp;
    private int port;
    private boolean started = false;
    private Channel channel;
    private Object serviceImpl;
    private String serviceName;
    private String zkConn;
    private String serviceRegisterPath;
    private EventLoopGroup bossGroup = new NioEventLoopGroup();
    private EventLoopGroup workerGroup = new NioEventLoopGroup();
    private CuratorFramework curatorFramework;

    public ServerImpl(int port, Object serviceImpl, String serviceName) {
        this.port = port;
        this.serviceImpl = serviceImpl;
        this.serviceName = serviceName;
    }

    public ServerImpl(int port, Object serviceImpl, String serviceName, String zkConn) {
        this.port = port;
        this.serviceImpl = serviceImpl;
        this.serviceName = serviceName;
        this.zkConn = zkConn;
    }


    @Override
    public void start() {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                                .addLast(new LoggingHandler(LogLevel.INFO))
                                .addLast(new RpcDecoder(10 * 1024 * 1024))
                                .addLast(new RpcEncoder())
                                .addLast(new RpcServerhandler(serviceImpl));
                    }
                });

        try {
            ChannelFuture future = serverBootstrap.bind(port).sync();
            registerService();
            LOG.info("Server started At {}", port);
            started = true;
            this.channel = future.channel();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void registerService() {
        zkConn = getZkConn();
        localIp = NetUtils.getLocalIP();
        String serviceIp = localIp + ":" + port;
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(zkConn, new ExponentialBackoffRetry(1000, 3));
        curatorFramework.start();
        String serviceBasePath = Constant.ZK_DATA_PATH + serviceName;

        try {
            curatorFramework.create()
                    .creatingParentContainersIfNeeded()
                    .forPath(serviceBasePath);


        } catch (Exception e) {
            if (e.getMessage().contains("NodeExist")) {
                LOG.info("This Path Service has already Exist");
            } else {
                LOG.error("Create Path Error", e);
                throw new RuntimeException("Regist error");
            }

        }

        boolean registerSuccess = false;

        while (!registerSuccess) {
            try {
                curatorFramework.create()
                        .withMode(CreateMode.EPHEMERAL)
                        .forPath(serviceBasePath + "/" + serviceIp);
                registerSuccess = true;
            } catch (Exception e) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                LOG.info("Retry Register ZooKeeper,{}", e.getMessage());
                try {
                    curatorFramework.delete().forPath(serviceBasePath + "/" + serviceIp);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }


    }

    @Override
    public void shutdown() {
        LOG.info("Shutting down service {}", serviceName);
        unRegister();
        if (curatorFramework != null) {
            curatorFramework.close();
        }
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();

    }

    private void unRegister() {
        LOG.info("unRegister zookeeper");
        try {
            curatorFramework.delete().forPath(Constant.ZK_DATA_PATH + serviceName + "/" + localIp + ":" + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getZkConn() {
        return zkConn;
    }

    public void setZkConn(String zkConn) {
        this.zkConn = zkConn;
    }

    public String getLocalIp() {
        return localIp;
    }

    public void setLocalIp(String localIp) {
        this.localIp = localIp;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

}
