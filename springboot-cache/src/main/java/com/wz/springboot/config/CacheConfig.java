package com.wz.springboot.config;


import com.wz.springboot.constant.GlobalConstant;
import com.wz.springboot.service.CacheService;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@EnableCaching
@Configuration
public class CacheConfig extends CachingConfigurerSupport {

    @Bean
    CacheService cacheService() {
        return new CacheService();
    }

    @Bean
    public CacheManager cacheManager() {
        // configure and return an implementation of Spring's CacheManager SPI
          SimpleCacheManager cacheManager = new SimpleCacheManager();
          cacheManager.setCaches(GlobalConstant.concurrentMapCaches);
        return cacheManager;
    }

    @Override
    public CacheResolver cacheResolver() {
        return null;
    }

    // 自定义key生成策略
    @Override
    public KeyGenerator keyGenerator() {
        return new MyKeyGenerator();
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return null;
    }
}
