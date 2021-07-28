package com.vyshnavi.aspects;

import com.vyshnavi.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnalyticsAspect {
    @Before("com.vyshnavi.aspects.ExpressionsAspect.forAccountDAO()")
    public void performingAPIAnalytics(JoinPoint joinPoint){
        System.out.println("\n---->>Performing API Analytics");
    }
}
