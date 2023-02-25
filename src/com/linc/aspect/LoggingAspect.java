package com.linc.aspect;

import com.linc.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {
    @Before("allCircleMethods()")
    public void LoggingAdvice(JoinPoint joinPoint) {
        Circle circle = (Circle) joinPoint.getTarget();
    }

    @AfterReturning(pointcut = "args(name)", returning ="returnValue")
    public void stringArgMethods(String name, Object returnValue) {
        System.out.println("A method that takes String Arguments called. The value is: " + name + " The output value is: " + returnValue);
    }

    @AfterThrowing(pointcut = "args(name)", throwing = "exception")
    public void exceptionAdvice(String name, Exception exception) {
        System.out.println("An exception has been thrown: " + exception.toString());
    }

    @Pointcut("execution(* get*(..))")
    public void allGetters() {}

    @Pointcut("within(com.linc.model.Circle)")
    public void allCircleMethods() {}
}
