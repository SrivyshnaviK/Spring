package com.vyshnavi;

import java.util.LinkedHashMap;

public class Student {
    private String firstName,lastName,country,countryCode,favoritePL;
    private LinkedHashMap<String,String> countryOptions;
    private String[] OS;
    public Student(){
        countryOptions=new LinkedHashMap<>();
        countryOptions.put("BR","Brazil");
        countryOptions.put("IND","India");
        countryOptions.put("GR","Germany");
        countryOptions.put("US","United States");
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getCountry() { return country;}
    public String getCountryCode() { return countryCode; }
    public LinkedHashMap<String, String> getCountryOptions() { return countryOptions; }

    public String getFavoritePL() {
        return favoritePL;
    }

    public String[] getOS() {
        return OS;
    }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setCountry(String country) { this.country = country; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }

    public void setFavoritePL(String favoritePL) {
        this.favoritePL = favoritePL;
    }

    public void setOS(String[] OS) {
        this.OS = OS;
    }
}
