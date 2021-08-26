package com.dag.leet.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author: donganguo
 * @date: 2021/8/24 5:04 下午
 * @Description: guava cache
 */
public class GuavaCacheTest {
    /**
     * 构造 LoadingCache 的关键在于实现 load 方法，
     * 也就是在需要访问的缓存项不存在的时候 Cache 会自动调用 load 方法将数据加载到 Cache 中。
     * 除了实现 load 方法之外还可以配置缓存相关的一些性质，比如过期加载策略、刷新策略 。
     */
    private static final LoadingCache<String, String> CACHE = CacheBuilder
            .newBuilder()
            .maximumSize(100)
            .expireAfterWrite(60*5, TimeUnit.SECONDS)
            .removalListener(notification -> System.out.println("cache expired, remove key : " + notification.getKey()))
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    return "cache [" + key + "]";
                }
            });

    /**
     * CallableCache的方式最大的特点在于可以在get的时候动态的指定load的数据源
     */
    private static final Cache<String, String> cache = CacheBuilder
            .newBuilder()
            .maximumSize(100)
            .expireAfterWrite(60*5, TimeUnit.SECONDS)
            .removalListener(notification -> System.out.println("cache expired, remove key : " + notification.getKey()))
            .build();

    public static void main(String[] args) throws ExecutionException {
        System.out.println(CACHE.get("KEY_25487"));

        System.out.println(cache.get("KEY_25488", () -> "cache [" + "KEY_25488" + "]"));
        cache.put("KEY_25499", "cache [" + "KEY_25499" + "]");
        System.out.println(cache.get("KEY_25499", () -> ""));
    }
}
