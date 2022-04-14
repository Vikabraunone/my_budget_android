package com.example.mybudget.models;

public class User {
    int id;
    String username;
    String email;
    String password;

    public User(int id, String username, String email, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
