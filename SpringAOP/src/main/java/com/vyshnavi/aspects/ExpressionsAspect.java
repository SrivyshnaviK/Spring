package com.vyshnavi.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class ExpressionsAspect {
    @Pointcut("execution(* com.vyshnavi.dao.AccountDAO.*(..))")
    public void forAccountDAO(){}
    @Pointcut("execution(* com.vyshnavi.dao.*.get*(..))")
    public void getter(){}
    @Pointcut("execution(* com.vyshnavi.dao.*.set*(..))")
    public void setter(){}
    @Pointcut("!(forAccountDAO() && !(getter() || setter()))")
    public void GS(){}
}
