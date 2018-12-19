package com.dxl.example.netty.server;

import com.dxl.example.netty.protocol.Request;
import com.dxl.example.netty.protocol.Response;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @Program RpcServerhandler
 * @Description
 * @Author duxl
 * @Create 2018/11/15 13:22
 */
public class RpcServerhandler extends SimpleChannelInboundHandler<Request> {
	private static final Logger LOG = LoggerFactory.getLogger(RpcServerhandler.class);
	private Object service;


	public RpcServerhandler(Object service) {
		this.service = service;
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Request msg) throws Exception {
		String methodName = msg.getMethod();
		Object[] params = msg.getParams();
		Class<?>[] parameterTypes = msg.getParameterTypes();
		long requestId = msg.getRequestId();
		Method method = service.getClass().getDeclaredMethod(methodName, parameterTypes);
		method.setAccessible(true);
		Object invoke = method.invoke(service, params);
		Response response = new Response();
		response.setRequestId(requestId);
		response.setResponse(invoke);
		ctx.pipeline().writeAndFlush(response);

	}


	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		LOG.error("Exception caught on {}", ctx.channel(), cause);
		ctx.channel().close();
	}
}
