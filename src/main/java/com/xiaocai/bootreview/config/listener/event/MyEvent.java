package com.xiaocai.bootreview.config.listener.event;

import com.xiaocai.bootreview.config.listener.handler.AbstractEventHandler;

import java.time.Clock;

/**
 * @ClassName MyEvent
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/11
 */
public class MyEvent extends AbstractEvent{
    /**
     * ApplicationEvent中的构造器
     *
     * @param source
     */
    public MyEvent(Object source) {
        super(source);
    }

    /**
     * ApplicationEvent中的构造器
     *
     * @param source
     * @param clock
     */
    public MyEvent(Object source, Clock clock) {
        super(source, clock);
    }



    private AbstractEventHandler eventHandler;

    /**
     * @param eventHandler 设置当前event对应的处理handler
     * @param source       source
     */
    public MyEvent(AbstractEventHandler eventHandler, Object source) {
        super(source);
        this.eventHandler = eventHandler;
    }

    public AbstractEventHandler getHandle() {
        return eventHandler;
    }
}
