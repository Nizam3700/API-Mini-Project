package com.example.details.Model;

public class User {
    
    private int id;
    private String name;
    private String father_name;
    private int age;
    private int session;

    public User(int id, String name, String father_name, int age, int session) {
        this.id = id;
        this.name = name;
        this.father_name = father_name;
        this.age = age;
        this.session = session;
    }

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

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    } 

    

    
}