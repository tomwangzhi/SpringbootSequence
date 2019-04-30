package com.wz.springboot.constant;

import org.springframework.cache.concurrent.ConcurrentMapCache;

import java.util.Arrays;
import java.util.List;

public class GlobalConstant {

    // 自定义的缓存，也可以使用redis作为缓存
    public static List<ConcurrentMapCache> concurrentMapCaches = Arrays.asList(new ConcurrentMapCache("cacheTest"));
}
