package com.cxx.test.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Create by Xiaoxu on 2018/6/6
 */
public class UserModel {
    private int id;
    private String name;
    private int age;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", birth=" + birth + "]";
    }
}
