package com.dxl.example.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author duxl
 * @date 2022/6/10 11:16
 */
@RestController("/wsTemplate")
public class WebSocketHandler {
//    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private SimpUserRegistry userRegistry;

//    @Resource(name = "redisServiceImpl")
//    private RedisService redisService;

    /**
     * 简单测试SimpMessagingTemplate的用法
     */
    @PostMapping("/greeting")
    @ResponseBody
    public String greeting(@RequestBody String greeting) {
        this.messagingTemplate.convertAndSend("/topic/greeting", new HelloMessage("Hello," + greeting + "!"));

        return "ok";
    }
}
