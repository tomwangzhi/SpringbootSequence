package com.wz.springboot.service;

import org.springframework.cache.annotation.Cacheable;

public class CacheService {

    @Cacheable(value = "cacheTest")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }
}
