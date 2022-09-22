package com.xiaocai.bootreview.threadPool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName ThreadPool
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/21
 */
@Configuration
public class ThreadPoolConfig {

    //使用java自带的ThreadPoolTaskExecutor 创建一个线程池
    @Bean(name="myDefaultThreadPool")
    public ThreadPoolTaskExecutor MyDefaultThreadPool(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());//拒绝策略
        threadPoolTaskExecutor.setCorePoolSize(2);//个续保宣布从个别高层公寓
        threadPoolTaskExecutor.setMaxPoolSize(10);//最大线程树
        threadPoolTaskExecutor.setQueueCapacity(10);//队列长度
        //允许的核心线程超时时间
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(true);
        threadPoolTaskExecutor.setAwaitTerminationMillis(5000);
        //设置线程名称前缀
        threadPoolTaskExecutor.setThreadNamePrefix("自定义基于java自己的线程池线程前缀-");
        //设置线程工厂
        //threadPoolTaskExecutor.setThreadFactory();
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
    @Bean(value = "simpleAsyncTaskExecutor")
    //重写springboot自带的线程池，原线程池count是-1
    public SimpleAsyncTaskExecutor getThreadPoolTaskExecutor2(){
        SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
        taskExecutor.setThreadGroupName("Simple组");//设置线程组名称
        taskExecutor.setTaskDecorator(new TaskDecorator() {//主要用例是围绕任务的调用设置一些执行上下文，或者为任务执行提供一些监控/统计。
            @Override
            public Runnable decorate(Runnable runnable) {
                return null;
            }
        });
        taskExecutor.setThreadNamePrefix("自定义SimpleAsync---");
        taskExecutor.setThreadPriority(1);
        taskExecutor.setConcurrencyLimit(10); //默认是-1没有限制
        return taskExecutor;
    }
}
