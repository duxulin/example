package com.dxl.example.netty.authoritative.guide.p8;

import com.google.protobuf.InvalidProtocolBufferException;
import com.sun.tools.javac.util.List;

import java.util.stream.Stream;

public class TestSubscribeReqProto {

    private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
        return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq() {
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqID(1)
                .setUserName("duxulin")
                .setProductName("Netty Book");
        builder.addAllAddress(List.of("Hangzhou XiHu", "ShaoXing ShangYu"));
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("Befor encode :" + req.toString());
        SubscribeReqProto.SubscribeReq decode = decode(encode(req));
        System.out.println("After decode :" + decode.toString());
        System.out.println("Assert equal :" + req.equals(decode));
    }
}
