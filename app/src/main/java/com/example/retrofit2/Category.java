package com.example.retrofit2;

import java.util.List;

public class Category{
    public String category_id;
    public String category_name;
    //public List<Subcatg> subcatg;

    public Category() {
    }

    public Category(String category_id, String category_name, List<Subcatg> subcatg) {
        this.category_id = category_id;
        this.category_name = category_name;
        //this.subcatg = subcatg;
    }

    public String getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

//    public List<Subcatg> getSubcatg() {
//        return subcatg;
//    }
}