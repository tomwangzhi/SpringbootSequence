package com.wz.springboot.springbootannotation;

import com.wz.springboot.springbootannotation.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringbootAnnotationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAnnotationApplication.class, args);
    }

}
