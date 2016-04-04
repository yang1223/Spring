package com.util;

/**
 * Created by Yang Chi-Chang on 2016/3/29.
 */
public class User {
    private final int id;
    private final String name;

    public User(int id , String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
