package com.xiaocai.bootreview.quartz.config;


import com.xiaocai.bootreview.quartz.job.FirstJob;
import com.xiaocai.bootreview.quartz.job.config.SecondJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.*;

/**
 * @ClassName QuartzConfig
 * @Description 第一个quartz的配置
 * @Author xiaocai
 * @Date 2022/9/18
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail() {
        //指定任务描述具体的实现类
        return JobBuilder.newJob(FirstJob.class)
                // 指定任务的名称
                .withIdentity("FirstJob")
                // 任务描述
                .withDescription("任务描述：用于输出冬奥欢迎语")
                // 每次任务执行后进行存储
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger() {
        //创建触发器
        return TriggerBuilder.newTrigger()
                // 绑定工作任务
                .forJob(jobDetail())
                // 每隔 100 秒执行一次 job
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(100))
                .build();
    }

    /**
     * 使用MethodInvokingJobDetailFactoryBean进行配置，自定义任务不需要实现Job接口
     * @param helloTask
     * @return
     */
    @Bean(name = "jobDetail1")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(SecondJob secondJob) {

        MethodInvokingJobDetailFactoryBean jobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
        //是否并发执行
        jobDetailFactoryBean.setConcurrent(false);
        //设置需要执行的实体类对应的对象
        jobDetailFactoryBean.setTargetObject(secondJob);
        //设置需要执行的方法
        jobDetailFactoryBean.setTargetMethod("sayHello");
        return jobDetailFactoryBean;
    }

    /**
     * 配置储发器
     * @param jobDetailFactoryBean
     * @return
     */
    @Bean(name = "cronJobTrigger2")
    public CronTriggerFactoryBean cronJobTrigger(MethodInvokingJobDetailFactoryBean jobDetailFactoryBean) {

        CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
        triggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        //设置cron表达式，10秒钟执行一次
        triggerFactoryBean.setCronExpression("*/10 * * * * ?");
        return triggerFactoryBean;
    }

    /**
     * 配置Scheduler
     * @param cronJobTrigger2
     * @return
     */
    @Bean(name = "scheduler1")
    public SchedulerFactoryBean schedulerFactoryBean(Trigger cronJobTrigger2) {

        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        //用于Quartz集群，QuartzScheduler启动时会更新已存在的Job
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        //延时启动，应用启动1秒后
        schedulerFactoryBean.setStartupDelay(1);
        //注册触发器
        schedulerFactoryBean.setTriggers(cronJobTrigger2);

        return schedulerFactoryBean;

    }
/*————————————————
    版权声明：本文为CSDN博主「江上飞鱼」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    原文链接：https://blog.csdn.net/jianghuiyun/article/details/90347915*/
}
