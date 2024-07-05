package com.leo.codes.client.model;

public class User {
    private String name;

    // Default constructor
    public User() {
    }

    // Constructor with parameters
    public User(String name) {
        this.name = name;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}