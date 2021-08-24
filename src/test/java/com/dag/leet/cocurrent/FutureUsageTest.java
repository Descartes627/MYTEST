package com.dag.leet.cocurrent;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

/**
 * @author: donganguo
 * @date: 2021/7/12 5:45 下午
 * @Description:
 */
public class FutureUsageTest {
    @Test
    public void testCalculate() throws InterruptedException, ExecutionException {
        Future<Integer> future1 = FutureUsage.calculate(20);
        Future<Integer> future2 = FutureUsage.calculate(200);
        while (!(future1.isDone() && future2.isDone())) {
            System.out.println(
                    String.format(
                                "future1 is %s and future2 is %s",
                                future1.isDone() ? "done" : "not done",
                                future2.isDone() ? "done" : "not done"
                            )
            );
            Thread.sleep(300);
        }
        Integer integer1 = future1.get();
        Integer integer2 = future2.get();
        System.out.println(integer1 + "and" + integer2);
    }

}