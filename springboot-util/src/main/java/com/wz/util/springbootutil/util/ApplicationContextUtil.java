package com.wz.util.springbootutil.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // TODO Auto-generated method stub
        ApplicationContextUtil.context = applicationContext;
    }

    public static Object getBean(String beanName) {

        return context==null?null:context.getBean(beanName);
    }

    public static <T> T getBean(Class<T> requiredType) {

        return context==null?null:context.getBean(requiredType);
    }

    public static String[] getBeanDefinitionNames() {

        return context.getBeanDefinitionNames();
    }
}