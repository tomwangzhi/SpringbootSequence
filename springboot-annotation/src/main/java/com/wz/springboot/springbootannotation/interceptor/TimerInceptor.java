package com.wz.springboot.springbootannotation.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TimerInceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("-----start  interceptor pre-------");
        System.out.println("类的名："+((HandlerMethod)handler).getClass().getName());
        System.out.println("方法名："+((HandlerMethod)handler).getMethod().getName());
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandler");
        Long startTime = (Long) request.getAttribute("startTime");
        System.out.println("执行时间为:\t" + (System.currentTimeMillis() - startTime) + "毫秒");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("completion");
        Long startTime = (Long) request.getAttribute("startTime");
        System.out.println("执行完Interceptor时间为:\t" + (System.currentTimeMillis() - startTime) + "毫秒");
        System.out.println("ex:\t" + ex);
    }
}
