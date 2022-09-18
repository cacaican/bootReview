package com.xiaocai.bootreview.javaTimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName javaTimerDemo
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/18
 */
public class javaTimerDemo {

    public static void main(String[] args) {
        Timer timer = new Timer();
        int delay= 5000;
        int period=50000;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(String.format("javaTimer定时任务,延时%s，间隔%s",delay,period));
            }
        },delay,period);

        Date date = new Date();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(String.format("javaTimer定时任务,指定时间%s，间隔%s",date,period));
            }
        },new Date(),period);
    }
}
