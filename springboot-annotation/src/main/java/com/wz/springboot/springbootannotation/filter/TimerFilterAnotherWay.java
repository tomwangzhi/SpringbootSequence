package com.wz.springboot.springbootannotation.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 第二种过滤器方式
 */
public class TimerFilterAnotherWay implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("-------timer filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("-------timer filter start");
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        long end = System.currentTimeMillis();
        System.out.println("----spent time "+(end-start)+"ms");
    }

    @Override
    public void destroy() {
        System.out.println("timer filter end ");
    }
}
