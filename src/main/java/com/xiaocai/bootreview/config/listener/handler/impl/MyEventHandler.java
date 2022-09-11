package com.xiaocai.bootreview.config.listener.handler.impl;

import com.xiaocai.bootreview.config.listener.event.MyEvent;
import com.xiaocai.bootreview.config.listener.handler.AbstractEventHandler;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName MyHandler
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/11
 */
@Component
public class MyEventHandler implements AbstractEventHandler {

    /**
     * //
     * REQUIRED(0), 如果当前没有事务，新建一个事务，如果有事务，加入当前事务
     * SUPPORTS(1), 如果当前没有事务，则以非事务方式运行，若有事务，则加入当前事务
     * MANDATORY(2), 强制使用事务，没有事务报错
     * REQUIRES_NEW(3), 如果当前没有事务，新建一个事务，如果有事务，挂起当前事务
     * NOT_SUPPORTED(4), 若有事务，将他挂起，以非事务方式运行
     * NEVER(5),       不允许事务，当前有事务报错
     * NESTED(6);     以嵌套的事务存在
     * requr
     * execute
     *
     * @param event event
     */
    @Override
    public void execute(ApplicationEvent event) {
        MyEvent xiaocaiEvent =(MyEvent) event;
        Map<String,Object> source = (Map<String,Object>) xiaocaiEvent.getSource();
        Set keySet = source.keySet();
        Iterator iterator = keySet.iterator();
        while(iterator.hasNext()) {
            String key = (String) iterator.next();
            Object o = source.get(key);
            System.out.println(xiaocaiEvent.getClass().getName()+"-------"+key +"---------------"+o);
        }
    }
}
