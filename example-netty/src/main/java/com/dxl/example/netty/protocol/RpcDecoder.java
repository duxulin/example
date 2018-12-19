package com.dxl.example.netty.protocol;

import com.dxl.example.netty.serializer.KryoSerializer;
import com.dxl.example.netty.serializer.Serializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Program RpcDecoder
 * @Description
 * @Author duxl
 * @Create 2018/11/15 13:10
 */
public class RpcDecoder extends LengthFieldBasedFrameDecoder {

	private static final Logger LOG = LoggerFactory.getLogger(RpcDecoder.class);
	private Serializer serializer = new KryoSerializer();

	public RpcDecoder(int maxFrameLength) {
		super(maxFrameLength, 0, 4, 0, 4);
	}


	/**
	 * @param ctx
	 * @param in
	 * @return
	 * @throws Exception
	 */
	@Override
	protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
		ByteBuf decode = (ByteBuf) super.decode(ctx, in);
		if (decode != null) {
			int byteLength = decode.readableBytes();
			byte[] byteHolder = new byte[byteLength];
			decode.readBytes(byteHolder);
			return serializer.deserializer(byteHolder);

		}
		LOG.debug("Decoder Result is null");
		return null;
	}
}
