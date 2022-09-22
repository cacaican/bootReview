package com.xiaocai.bootreview.threadPool;

import com.xiaocai.bootreview.AbstractTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import static org.junit.jupiter.api.Assertions.*;

public class ThreadTest extends AbstractTest {


    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private SimpleAsyncTaskExecutor simpleAsyncTaskExecutor;

    @Test
    public void test01() throws ExecutionException, InterruptedException {
        /*Future<?> future = threadPoolTaskExecutor.submit(new RunnableTask1());  //调用future.get()前正常执行，调用future.get()后报除零异常
        System.out.printf("打印的结果1为%s \r\n",future.get());*/

        /*Future<?> future2 = simpleAsyncTaskExecutor.submit(new RunnableTask1());//都报错，空指针
        System.out.printf("打印的结果2为%s \r\n",future2.get());*/

       /* Future<?> future3 = threadPoolTaskExecutor.submit(new CallableTask1()); //调用future.get()前正常执行，调用future.get()后报除零异常
        System.out.printf("打印的结果3为%s \r\n",future3.get());

        Future<String> future4 = simpleAsyncTaskExecutor.submit(new CallableTask1()); //调用future.get()前正常执行，调用future.get()后报除空指针：怀疑是simpleAsyncTaskExecutor初始化的问题
        System.out.printf("打印的结果4为%s \r\n",future4.get());*/

        FutureTask2 futureTask2 = new FutureTask2(new RunnableTask1(),new String("123564"));
        threadPoolTaskExecutor.submit(futureTask2);//调用future.get()前正常执行，调用future.get()后报除零异常
        System.out.printf("打印的结果5为%s \r\n",futureTask2.get());

        FutureTask1 futureTask1 = new FutureTask1(new CallableTask1());
        threadPoolTaskExecutor.submit(futureTask1);//调用future.get()前正常执行，调用future.get()后报除零异常
        System.out.printf("%s打印的结果6为%s \r\n",Thread.currentThread().getName(),futureTask1.get());



    }

}