package com.dag.leet.cocurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

/**
 * @author: donganguo
 * @date: 2021/7/12 5:42 下午
 * @Description:
 */
public class FutureUsage {
    static int i = 100;
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();


    static void test(Supplier<Integer> supplier){}

    public static Future<Integer> calculate(Integer input) {
//        i = 101;
        test(() -> {
            if (i == 0)
                return 0;
            else
                return 1;
        });


        return executorService.submit(() -> {
            System.out.println("Calculating..."+ input);
            Thread.sleep(1000);
            return input * input;
        });
    }
}
