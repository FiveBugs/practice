package com.pony.springboothelloworld.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {

    @Pointcut("execution(* com.pony.springboothelloworld.service.PrintService.*(..))")
    public void helloPointcut() {
    }

    @Before("helloPointcut()")
    public void beforeHello() {
        System.out.println("beforeHellos");
    }

    @After("helloPointcut()")
    public void afterHello() {
        System.out.println("afterHello");
    }
}
