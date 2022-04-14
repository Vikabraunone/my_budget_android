package com.example.mybudget.models;

import java.io.Serializable;

public class Account implements Serializable {
    public int id;
    public String accountName;
    public Double amount;

    public Account(int id, String accountName, Double amount){
        this.id = id;
        this.accountName = accountName;
        this.amount = amount;
    }

    public Account(){}
}
