package com.xiaocai.bootreview.quartz.job.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName SecondJob
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/18
 */
//@Configuration
@Component
//@EnableScheduling
public class SecondJob {

    public void sayHello() {
        System.out.println("hello word");
    }
}
