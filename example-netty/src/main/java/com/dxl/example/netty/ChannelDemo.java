package com.dxl.example.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Program ChannelDemo
 * @Description
 * @Author duxl
 * @Create 2018/11/15 11:15
 */
public class ChannelDemo extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);


    }
}
