package com.dag.leet.cocurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: donganguo
 * @date: 2021/8/20 3:35 下午
 * @Description:
 */
public class ThreadLocalUsage {
    //初始化thread-local 变量为0
    private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    private static final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 10, 30L, TimeUnit.SECONDS, new SynchronousQueue<>(), new NameTreadFactory());

    static class NameTreadFactory implements ThreadFactory {

        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }
    }

    public static int getValue() {
        return threadLocal.get();
    }

    public static void increment() {
        threadLocal.set(threadLocal.get() + 1);
    }

    public static void remove() {
        threadLocal.remove();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                try {
                    int before = getValue();
                    increment();
                    int after = getValue();
                    System.out.println(Thread.currentThread().getName() + " before: " + before + ", after: " + after);
                }
                finally {
//                    remove();
                }
            });
        }
        //不shutdown的话，jvm进程会存活
        threadPool.shutdown();
    }

}
