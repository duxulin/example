package com.dxl.example.netty.protocol;

import com.dxl.example.netty.serializer.KryoSerializer;
import com.dxl.example.netty.serializer.Serializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Program RpcEncoder
 * @Description
 * @Author duxl
 * @Create 2018/11/15 13:03
 */
public class RpcEncoder extends MessageToByteEncoder<Object> {
	private Serializer serializer = new KryoSerializer();


	@Override
	protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
		byte[] bytes = this.serializer.serializer(msg);
		int length = bytes.length;
		out.writeInt(length);
		out.writeBytes(bytes);
	}
}
