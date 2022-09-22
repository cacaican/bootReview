package com.xiaocai.bootreview.threadPool;

/**
 * @ClassName Task1
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/21
 */
public class RunnableTask1 implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.printf("线程前缀为%s :执行RunnableTask1 线程任务\n" , Thread.currentThread().getName());
//        int i=1/0;
    }
}
