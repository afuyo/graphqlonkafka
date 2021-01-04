package com.graphql.graphqltools1.models;

public class User1 {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User1(String name, int age) {
        this.name = name;
        this.age = age;
 }
}