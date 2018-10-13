package com.houfalyu.mmall.util;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by houfalv on 2018/10/12.
 * 使用Guava 实现本地 token
 * 同时也可以考虑使用Map 集合来完成缓存设计
 */
public class TokenCache {

    private static Logger logger = LoggerFactory.getLogger(TokenCache.class);

    //LRU 算法
    private static LoadingCache<String, String> localCache = CacheBuilder.newBuilder().
            initialCapacity(1000).
            maximumSize(10000).
            expireAfterAccess(12, TimeUnit.HOURS).
            build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    return null;
                }
            });

    /**
     * 将String 放入缓存
     * @param key
     * @param value
     */
    public static void putCache(String key, String value) {
        localCache.put(key, value);
    }

    /**
     * 从缓存中得到value
     *
     * @param key
     * @return
     */
    public static String getValue(String key) {
        String value = null;
        try {
            value = localCache.get(key);
            if ("null".equals(value)) {
                return null;
            }
            return value;
        } catch (ExecutionException e) {
            e.printStackTrace();
            logger.info("加载缓存异常!",e.getMessage());
        }
        return null;
    }
}
