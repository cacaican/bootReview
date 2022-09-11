package com.xiaocai.bootreview.config.listener.handler;

import org.springframework.context.ApplicationEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName AbstractEventHandler
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/11
 */
public interface AbstractEventHandler {
    default void testDefault(){
        System.out.println("这里测试了接口中的default方法");
    }

    static void testStatic(){
        System.out.println("这里测试了接口中的Static方法");
    }
    /**
     * //
     *     REQUIRED(0), 如果当前没有事务，新建一个事务，如果有事务，加入当前事务
     *     SUPPORTS(1), 如果当前没有事务，则以非事务方式运行，若有事务，则加入当前事务
     *     MANDATORY(2), 强制使用事务，没有事务报错
     *     REQUIRES_NEW(3), 如果当前没有事务，新建一个事务，如果有事务，挂起当前事务
     *     NOT_SUPPORTED(4), 若有事务，将他挂起，以非事务方式运行
     *     NEVER(5),       不允许事务，当前有事务报错
     *     NESTED(6);     以嵌套的事务存在
     * requr
     * execute
     * @param event event
     */
    @Async
    @Transactional(propagation = Propagation.REQUIRED)
    //@Transactional(propagation = Propagation.MANDATORY) /* 会报错，没有与发布事件的代码在同一个事务里面)*/
    void execute(ApplicationEvent event);
}
