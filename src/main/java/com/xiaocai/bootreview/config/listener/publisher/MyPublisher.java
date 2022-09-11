package com.xiaocai.bootreview.config.listener.publisher;

import com.xiaocai.bootreview.config.listener.event.MyEvent;
import com.xiaocai.bootreview.config.listener.handler.AbstractEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @ClassName MyPublisher
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/11
 */
@Component
public class MyPublisher {

    /**
     * eventPublisher：这里装配了spring自带的事件发布
     */
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    /**
     * myHandler：我自定义的事件处理器
     */
    @Autowired
    @Qualifier("myEventHandler")
    private AbstractEventHandler myEventHandler;

    public void publishMyEvent(){
        HashMap<String, Object> map = new HashMap<>();

        map.put("1","xiaocai");
        map.put("2","是");
        map.put("3","天");
        map.put("4","才");
        map.put("5","a");
        eventPublisher.publishEvent(new MyEvent(myEventHandler,map));

    }
}
