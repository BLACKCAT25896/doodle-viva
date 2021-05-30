package com.example.retrofit2;

public class Subcatg{
    public String sub_category_id;
    public String sub_category_name;

    public Subcatg() {
    }

    public Subcatg(String sub_category_id, String sub_category_name) {
        this.sub_category_id = sub_category_id;
        this.sub_category_name = sub_category_name;
    }

    public String getSub_category_id() {
        return sub_category_id;
    }

    public String getSub_category_name() {
        return sub_category_name;
    }
}
