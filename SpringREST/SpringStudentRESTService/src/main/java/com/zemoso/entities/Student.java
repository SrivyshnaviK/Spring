package com.zemoso.entities;

public class Student {

    private String firstName,lastName;
    public Student(){}
    public Student(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
}
