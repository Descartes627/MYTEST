package com.dag.leet;

/**
 * @author: donganguo
 * @date: 2021/7/1 4:15 下午
 * @Description:
 */
@FunctionalInterface
public interface MyConsumer<T> {
    void accept(T t);
}
