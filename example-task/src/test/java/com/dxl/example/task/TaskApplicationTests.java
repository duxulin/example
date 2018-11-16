package com.dxl.example.task;

import com.dxl.example.task.ScheduledTasks;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Program ScheduledTasksTest
 * @Description
 * @Author duxl
 * @Create 2018/11/14 15:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskApplicationTests {
    @Autowired
    ScheduledTasks scheduledTasks;

    @Test
    public void sss() {
        while (true) {

        }
    }


}
