package com.xiaocai.bootreview.threadPool.task;

import java.util.concurrent.Callable;

/**
 * @ClassName CallableTask1
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/21
 */
public class CallableTask1 implements Callable {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Object call() throws Exception {
        System.out.printf("线程前缀为%s :执行CallableTask1 线程任务\n" , Thread.currentThread().getName());
//        int i=1/0;
        return Thread.currentThread().getName();
    }
}
