package com.sinsz.test.bio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 创建线程池
 */
public class TimeServerHandlerExecutePool {

    private ExecutorService executerService;

    public TimeServerHandlerExecutePool(int maxPoolSize,int queueSize) {

        this.executerService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),maxPoolSize,120L,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(queueSize));

    }

    public void execute(Runnable task){
        executerService.execute(task);
    }
}
