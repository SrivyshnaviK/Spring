package com.zemoso;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JSONApp {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper=new ObjectMapper();
            Student student=objectMapper.readValue(new File("data/sample-lite.json"), Student.class);
            System.out.println("First Name:"+student.getFirstName());
            System.out.println("Last Name:"+student.getLastName());
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        try {
            ObjectMapper objectMapper=new ObjectMapper();
            Student student=objectMapper.readValue(new File("data/sample-full.json"), Student.class);
            System.out.println("\nFirst Name:"+student.getFirstName());
            System.out.println("Last Name:"+student.getLastName());
            System.out.println("Street:"+student.getAddress().getStreet());
            System.out.println("City:"+student.getAddress().getCity());
            System.out.println("Languages:");
            for(String language:student.getLanguages())
                System.out.println(language);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
