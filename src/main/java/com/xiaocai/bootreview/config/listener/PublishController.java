package com.xiaocai.bootreview.config.listener;

import com.xiaocai.bootreview.config.listener.publisher.MyPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName publishController
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/11
 */
@RestController
@RequestMapping("/event")
public class PublishController {

    @Autowired
    private MyPublisher myPublisher;

    @RequestMapping(value = "/publishMyEvent",method = RequestMethod.GET)
    public String publishMyEvent(){
        myPublisher.publishMyEvent();
        return "success";
    }
}
