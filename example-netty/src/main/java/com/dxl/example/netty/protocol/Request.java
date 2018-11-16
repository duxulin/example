package com.dxl.example.netty.protocol;

import lombok.Data;

/**
 * @Program Request
 * @Description
 * @Author duxl
 * @Create 2018/11/15 11:27
 */
@Data
public class Request {

    private long requestId;
    private Class<?> clazz;
    private String method;
    private Class<?>[] parameterTypes;
    private Object[] params;
    private long requestTime;
}
