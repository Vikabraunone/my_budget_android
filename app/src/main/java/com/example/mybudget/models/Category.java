package com.example.mybudget.models;

import java.io.Serializable;

public class Category implements Serializable {
    public int id;
    public String categoryName;

    public Category(int id, String categoryName){
        this.id = id;
        this.categoryName = categoryName;
    }
}
