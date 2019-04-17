package com.wz.springboot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.DefaultedRedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
public class RedisConfig {


    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
//        RedisConnectionFactory redisConnectionFactory = new DefaultedRedisConnection();
        return null;
    }
}
