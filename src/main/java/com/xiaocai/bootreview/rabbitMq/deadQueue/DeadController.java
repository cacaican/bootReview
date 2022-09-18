package com.xiaocai.bootreview.rabbitMq.deadQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName controller
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/18
 */
@RestController
@RequestMapping("/deadQueue")
public class DeadController {
    @Autowired
    private Sender sender;

    @RequestMapping("/testDead")
    public String testDead(){
        sender.sendMore();
        return "success";
    }
}
