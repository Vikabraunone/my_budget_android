package com.example.mybudget.models;

import java.io.Serializable;

public class Subcategory implements Serializable {
    public int id;
    public int categoryId;
    public String subcategoryName;

    public Subcategory(int id, int categoryId, String categoryName){
        this.id = id;
        this.categoryId = categoryId;
        this.subcategoryName = categoryName;
    }
}
