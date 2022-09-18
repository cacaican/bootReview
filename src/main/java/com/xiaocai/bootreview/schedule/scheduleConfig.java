package com.xiaocai.bootreview.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName scheduleConfig
 * @Description springbooot自带定时任务
 * @Author xiaocai
 * @Date 2022/9/18
 */
@Component
public class scheduleConfig {

    //表示方法执行完成后5秒
    @Scheduled(fixedDelay = 5000000)
    public void fixedDelayJob() throws InterruptedException {
        System.out.println("fixedDelay 每隔5000秒" + new Date());
    }

    //表示每隔3秒
    @Scheduled(fixedRate = 3000000)
    public void fixedRateJob() {

        System.out.println("fixedRate 每隔3000秒" + new Date());
    }

    //表示每天8时30分0秒执行
    @Scheduled(cron = "0 0,30 0,8 ? * ? ")
    public void cronJob() {
        System.out.println(new Date() + " ...>>cron....");
    }
}
