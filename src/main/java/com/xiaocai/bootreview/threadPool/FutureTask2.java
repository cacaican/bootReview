package com.xiaocai.bootreview.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @ClassName FutureTask1
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/21
 */
public class FutureTask2 extends FutureTask {

    /**
     * Creates a {@code FutureTask} that will, upon running, execute the
     * given {@code Runnable}, and arrange that {@code get} will return the
     * given result on successful completion.
     *
     * @param runnable the runnable task
     * @param result   the result to return on successful completion. If
     *                 you don't need a particular result, consider using
     *                 constructions of the form:
     *                 {@code Future<?> f = new FutureTask<Void>(runnable, null)}
     * @throws NullPointerException if the runnable is null
     */
    public FutureTask2(Runnable runnable, Object result) {
        super(runnable, result);
    }
}
