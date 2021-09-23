package com.example.crudwithh2java;

public class Emp {
    int id;
    String name;
    String email;
    String profession;

    public Emp() {
    }

    public Emp(int id) {
        this.id = id;
        }

    public Emp(String name, String email, String profession) {
        this.name = name;
        this.email = email;
        this.profession = profession;
    }

    public Emp(int id, String name, String email, String profession) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profession = profession;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
