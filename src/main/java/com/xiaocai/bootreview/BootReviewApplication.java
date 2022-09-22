package com.xiaocai.bootreview;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//要注意这个扫描范围，这个范围下的所有接口都会自动生成实现类，可能导致重复实例化
@MapperScan(basePackages = {"com.xiaocai.bootreview.ssm.mapper"})
@ServletComponentScan(basePackages ={"com.xiaocai.bootreview.config.servlet"})
@EnableAsync
@EnableScheduling //开启定时任务
public class BootReviewApplication {


    //复习下springboot的启动过程
    //首先看SpringApplication的new过程
    //定义了以下几个资源
        /*
        primarySources：自己
        webApplicationType：推断应用类型
        设置引导注册表初始化程序：bootstrapRegistryInitializers

        */
    //创建工厂实例：META-INF/spring.factories
    //初始化上下文
    //初始化监听器setInitializers
    //deduceMainApplicationClass


    //run方法的使用
   /* 1.记录启动时间
    2.创建启动上下文createBootstrapContext
//    3.设置异常报告期2.6版本没有这个
    3.设置configureHeadlessProperty属性
    4.SpringApplicationRunListeners：获取监听器并且开启监听


    创建applicationArguments
    准备运行环境：prepareEnvironment
    configureIgnoreBeanInfo
    打印banner：printBanner
    创建应用上下文：createApplicationContext
    设置启动：setApplicationStartup
    prepareContext
    refreshContext
    afterRefresh
    listeners.started(）
    callRunners：在刷新上下文后调用*/
    public static void main(String[] args) {

        SpringApplication.run(BootReviewApplication.class, args);
//        SpringApplication application = new SpringApplication();
//        application.run(args);
    }

}
