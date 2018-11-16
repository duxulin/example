package com.dxl.example.netty.serializer;

/**
 * @Program Serializer
 * @Description
 * @Author duxl
 * @Create 2018/11/15 11:35
 */
public interface Serializer {

    byte[] serializer(Object obj);

    <T> T deserializer(byte[] bytes);

}
