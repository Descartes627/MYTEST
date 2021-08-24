package com.dag.leet;


import org.junit.Test;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: donganguo
 * @date: 2021/7/1 7:04 下午
 * @Description: Stream.iterate定义流迭代的方式并返回一个无限流,limit限制流长度，a可以说是下标
 * skip跳跃流抛弃之前的元素
 */
public class SolutionTest {
    @Test
    public void test() {
        List<Integer> list = new ArrayList<>(1001);
        for (int i = 0; i < 950; i++) {
            list.add(i);
        }
        int maxStep = list.size()/100 + 1;
        List<List<Integer>> collect = Stream.iterate(0, f -> f + 1)
                .limit(maxStep)
                .parallel()
                .map(a -> list.stream().skip(a * 100).limit(100).collect(Collectors.toList()))
                .collect(Collectors.toList());
        System.out.println(collect.get(1));


//        Optional<String> max = stream.filter(s -> s.length() >= 3).max(
//                Comparator.comparingInt(String::length)
//        );
//        max.ifPresent(str -> System.out.println(str));
//        Integer reduce = stream.reduce(0,
//                (sum, str) -> sum + str.length(),
//                (a, b) -> a + b);
//
//        stream.collect(Collectors.toList());
    }

    @Test
    public void testInteger() {
        Integer i = -129;
        Integer integer = -129;
        System.out.println(i==integer);
    }

    @Test
    public void testFuture() {

    }

}