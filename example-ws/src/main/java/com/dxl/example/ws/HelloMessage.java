package com.dxl.example.ws;

/**
 * @author duxl
 * @date 2022/6/10 11:19
 */

public class HelloMessage {

    private String content;
    public HelloMessage(String content) {
        this.content = content;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
