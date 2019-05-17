package com.wz.springboot.springbootannotation.config;

import com.wz.springboot.springbootannotation.filter.TimerFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

// 方式一与方式二的区别：
//方式二可以引入第三方过滤器，算是方式一的扩展
@Configuration
public class WebFilterConfig {

    @Bean
    FilterRegistrationBean timeFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        TimerFilter timerFilter = new TimerFilter();
        // 添加过滤器
        filterRegistrationBean.setFilter(timerFilter);

        ArrayList<String> urls = new ArrayList<>();
        urls.add("/*");
        filterRegistrationBean.setUrlPatterns(urls);
        return filterRegistrationBean;

    }
}
