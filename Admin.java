package com.example.lab3;

public class Admin {

    private int id;
    private String name;
    private String email;
    private int password;
    public Admin(int id, String name, String email, int password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public int getPassword() {
        return password;
    }
}
