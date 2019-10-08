package com.wz.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class BeanConfigs {

    @Bean
    public javax.validation.Validator getValidator(){
        return new LocalValidatorFactoryBean();
    }
}
