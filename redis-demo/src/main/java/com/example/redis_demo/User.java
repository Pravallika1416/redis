package com.example.redis_demo;



import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String name;

    // Constructors
    public User() {}

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

