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

    public static void main(String[] args) {
        SpringApplication.run(BootReviewApplication.class, args);
    }

}
