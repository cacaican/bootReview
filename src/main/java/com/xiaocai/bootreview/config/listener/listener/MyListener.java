package com.xiaocai.bootreview.config.listener.listener;

import com.xiaocai.bootreview.config.listener.event.AbstractEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @ClassName MyListener
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/11
 */
@Component
public class MyListener /*implements ApplicationListener*/ {

    /*
    TransactionalEventListener注解的作用 :表示事件发布代码所在事务操作成功/失败后执行
    BEFORE_COMMIT,指定目标方法在事务commit之前执行
    AFTER_COMMIT,指定目标方法在事务commit之后执行
    AFTER_ROLLBACK, 指定目标方法在事务rollback之后执行
    AFTER_COMPLETION 指定目标方法在事务完成时执行，这里的完成是指无论事务是成功提交还是事务回滚了
    ————————————————
    版权声明：本文为CSDN博主「Evan Wang」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    原文链接：https://blog.csdn.net/qq_41378597/article/details/105748703*/

    // 主要通过这两个注解触发开启对事件的监听，
      @EventListener(value = AbstractEvent.class)
//    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT, value = AbstractEvent.class),使用这个注解需要实现ApplicationListener，不然监听不到时间
    public void onAbstractEvent(AbstractEvent event) {
        System.out.println("MyListener监听到event");
        event.getHandle().execute(event);
    }

   /* @Override
    public void onApplicationEvent(ApplicationEvent event) {
        AbstractEvent abstractEvent = (AbstractEvent)event;
        System.out.println("MyListener监听到abstractEvent");
        abstractEvent.getHandle().execute(event);
    }*/
}
