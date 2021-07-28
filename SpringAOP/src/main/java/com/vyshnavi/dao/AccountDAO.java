package com.vyshnavi.dao;

import com.vyshnavi.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
    private String name;
    public List<Account> listAccounts(){
        List<Account> accounts=new ArrayList<>();
        Account account1=new Account("Vyshnavi","Platinum");
        Account account2=new Account("Krishna","Gold");
        accounts.add(account1);
        accounts.add(account2);
        return accounts;
    }
    public void setName(String name) {
        System.out.println(getClass()+" Setter");
        this.name = name;
    }

    public String getName() {
        System.out.println(getClass()+" Getter");
        return name;
    }
    public void addAccount(Account account, boolean vipFlag){
        System.out.println(getClass()+": doing my DB Work -- Adding an Account");
    }
    public void work(){
        System.out.println("Doing Work..");
    }

    public void listAccountsWithException() {
        throw new RuntimeException("After Throwing Demo Checking Exception!!!");
    }
}

