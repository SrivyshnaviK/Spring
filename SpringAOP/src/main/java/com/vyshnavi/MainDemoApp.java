package com.vyshnavi;

import com.vyshnavi.dao.AccountDAO;
import com.vyshnavi.dao.MembershipDAO;
import com.vyshnavi.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class MainDemoApp {
    public static void main(String[] args) {
        Logger logger=Logger.getLogger(MainDemoApp.class.getName());
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
        MembershipDAO membershipDAO=context.getBean("membershipDAO",MembershipDAO.class);
        Account account=new Account();
        accountDAO.setName("New Name");
        accountDAO.getName();
        accountDAO.addAccount(account,true);
        accountDAO.work();
        membershipDAO.addSillyAccount();
        logger.info("\n\n=====After Returning Demo=====");
        logger.info(accountDAO.listAccounts().toString());
        logger.info("\n\n=====After Throwing Demo=====");
        try{
            accountDAO.listAccountsWithException();
        }
        catch (Exception exception){
            logger.info("\nException Caught In Main Code:"+exception);
        }
        logger.info("\n\n=====Around Demo=====");
        TrafficFortuneService trafficFortuneService=context.getBean("trafficFortuneService",TrafficFortuneService.class);
        logger.info("Fortune Returned is:"+trafficFortuneService.getFortune());
        logger.info("\n\n=====Around Demo Handling Exceptions=====");
        logger.info("Fortune Exception:"+trafficFortuneService.getFortuneWithException());
        context.close();
    }
}
