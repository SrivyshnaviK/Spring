package com.vyshnavi.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addSillyAccount(){
        System.out.println(getClass()+": doing my DB Work -- Adding an Account");
    }
}
