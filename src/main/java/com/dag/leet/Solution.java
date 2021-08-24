package com.dag.leet;

import org.springframework.cache.annotation.Cacheable;

import java.util.*;
import java.util.function.BinaryOperator;

public class Solution {

    @Cacheable
    public int getValue() {
        return 1;
    }

    public static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    void test() {
        BinaryOperator<Long> addImplicit = (x, y) -> x + y;// 5 类型推断
        Runnable hello = () -> System.out.println("hello");
        BinaryOperator<String> minBy = BinaryOperator.minBy((o1, o2) -> 0);
        minBy.apply("hi","ha");
        Math.min(1, 2);
    }

    public static void main(String[] args) throws InterruptedException {

    }

}
