package com.vyshnavi;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcURL="jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false";
        String user="hbstudent",password="hbstudent";
        try{
            System.out.println("Connecting to Database...");
            Connection connection= DriverManager.getConnection(jdbcURL,user,password);
            System.out.println("Connection Established Succesfully!!!");
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
