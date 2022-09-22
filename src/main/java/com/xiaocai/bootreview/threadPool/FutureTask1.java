package com.xiaocai.bootreview.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @ClassName FutureTask1
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/21
 */
public class FutureTask1 extends FutureTask {
    /**
     * Creates a {@code FutureTask} that will, upon running, execute the
     * given {@code Callable}.
     *
     * @param callable the callable task
     * @throws NullPointerException if the callable is null
     */
    public FutureTask1(Callable callable) {
        super(callable);
    }
}
