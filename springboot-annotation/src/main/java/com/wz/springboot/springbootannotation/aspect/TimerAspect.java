package com.wz.springboot.springbootannotation.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimerAspect {

    @Around(value = "execution(* com.wz.springboot.springbootannotation.test.ExcetptionHappenMainController.*(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint point) throws Throwable {

        System.out.println("time aspect start");
        Object[] args = point.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("arg is "+args[i]);
        }
        Object object = point.proceed();
        System.out.println("timer aspect end");
        return object;
    }

}
