package com.dxl.example.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Program ScheduledTasks
 * @Description
 * @Author duxl
 * @Create 2018/11/14 15:33
 */
@Component
public class ScheduledTasks {

    private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        LOG.info("the time is now:{}", new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }
}
