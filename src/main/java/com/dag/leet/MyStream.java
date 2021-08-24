package com.dag.leet;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: donganguo
 * @date: 2021/7/1 4:17 下午
 * @Description:
 */
@Data
public class MyStream<T> {
    private List<T> list;

    //forEach传一个迭代器,迭代器对MyStream下的每个元素进行操作
    public void myForEach(MyConsumer<T> myIterator) {
        for (T t : list) {
            myIterator.accept(t);
        }
    }

    public static void main(String[] args) {
        List<MyStream<String>> list = new ArrayList<>();
        MyStream<String> stream = new MyStream<>();
        stream.list = Arrays.asList("args", "hello");
        stream.myForEach(
                System.out::println
        );
        list.add(stream);
        list.get(0).myForEach(System.out::println);
    }
}
