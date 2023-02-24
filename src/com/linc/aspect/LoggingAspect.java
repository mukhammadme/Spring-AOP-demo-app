package com.linc.aspect;

import com.linc.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
    @Before("allCircleMethods()")
    public void LoggingAdvice(JoinPoint joinPoint) {
        Circle circle = (Circle) joinPoint.getTarget();
    }

    @Before("args(name)")
    public void stringArgMethods(String name) {
        System.out.println("A method that takes String Arguments called. The value is: " + name);
    }

    @Pointcut("execution(* get*(..))")
    public void allGetters() {}

    @Pointcut("within(com.linc.model.Circle)")
    public void allCircleMethods() {}
}
