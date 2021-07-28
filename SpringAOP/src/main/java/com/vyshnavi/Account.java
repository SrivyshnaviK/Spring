package com.vyshnavi;
public class Account {
    private String name;
    private String level;
    public Account(){}
    public Account(String name,String level){
        this.name=name;
        this.level=level;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public String getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
