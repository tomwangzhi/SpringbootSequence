package com.wz.springboot.config;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

public class MyKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object o, Method method, Object... objects) {
        return null;
    }
}
