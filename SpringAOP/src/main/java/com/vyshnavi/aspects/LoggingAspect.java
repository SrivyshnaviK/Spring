package com.vyshnavi.aspects;

import com.vyshnavi.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LoggingAspect {
    Logger logger=Logger.getLogger(getClass().getName());
    @Before("com.vyshnavi.aspects.ExpressionsAspect.forAccountDAO()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        logger.info("\n---->>Executing @before advice on AddAccount");
    }
    @Before("com.vyshnavi.aspects.ExpressionsAspect.GS()")
    public void performingGS(JoinPoint joinPoint){
        logger.info("\n---->>For Getter and Setters");
        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
        logger.info("Method Signature of Called Method:"+methodSignature);
        Object[] args = joinPoint.getArgs();
        for (Object tempArg : args) {
            logger.info(tempArg.toString());
            if (tempArg instanceof Account) {
                Account theAccount = (Account) tempArg;
                logger.info("account name: " + theAccount.getName());
                logger.info("account level: " + theAccount.getLevel());
            }}
    }
    @Around("execution(* com.vyshnavi.service.*.getFortune*(..))")
    public Object aroundInFortuneService(ProceedingJoinPoint joinPoint) throws Throwable{
        Object result=null;
        logger.info("\n---->>Executing @Around");
        logger.info("Method Signature:"+joinPoint.getSignature().toShortString());
        long begin=System.currentTimeMillis();
        try{
       result=joinPoint.proceed();}
        catch (Exception exception) {
            logger.warning(exception.getMessage());
            //throw exception;
            logger.info("@Around.. Exception Handled");
            result="Alternate Option available..";
        }
        long end=System.currentTimeMillis();
        logger.info("--->>Duration:"+(end-begin)/1000+" secs");
        return result;
    }
    @After("execution(* com.vyshnavi.dao.AccountDAO.listAccounts*(..))")
    public void afterFinally(JoinPoint joinPoint){
        logger.info("\n---->>Executing @After (Finally) Method Execution Of ListAccounts");
        logger.info("Method Signature:"+joinPoint.getSignature());
    }
    @AfterReturning(pointcut = "execution(* com.vyshnavi.dao.AccountDAO.listAccounts(..))",returning = "list")
    public void afterReturningFromListingAccounts(JoinPoint joinPoint, List<Account> list){
        logger.info("\n---->>Executing @After Returning From ListAccounts");
        logger.info("Method Signature:"+joinPoint.getSignature());
        logger.info("Result is:"+list);
        logger.info("Modifying Account List Before Returning");
        convertToUpperCase(list);
        logger.info("Result after modifying is:"+list);
    }
    @AfterThrowing(pointcut = "execution(* com.vyshnavi.dao.AccountDAO.listAccounts*(..))",throwing = "exception")
    public void afterThrowingExceptionFromListingAccounts(JoinPoint joinPoint, Throwable exception){
        logger.info("\n---->>Executing @After Throwing Exception From ListAccounts");
        logger.info("Method Signature:"+joinPoint.getSignature());
        logger.info("Exception Caught in Aspect:"+exception);
    }
    private void convertToUpperCase(List<Account> list) {
        for(Account account: list){
            String upperCase=account.getName().toUpperCase();
            account.setName(upperCase);
        }
    }
}
