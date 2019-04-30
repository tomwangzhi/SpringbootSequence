package com.wz.springboot;

import com.wz.springboot.constant.GlobalConstant;
import com.wz.springboot.service.CacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {

    @Autowired
    CacheService cacheService;
    @Test
    public void contextLoads() {

        cacheService.hello();
        cacheService.hello();
        cacheService.hello();
        System.out.println(GlobalConstant.concurrentMapCaches);
    }

}
