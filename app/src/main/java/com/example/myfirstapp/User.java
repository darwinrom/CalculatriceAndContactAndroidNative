package com.example.myfirstapp;

public class User {

    private String first_name;
    private String last_name;
    private int age;
    private String sexe;
    private String phone;

    public User(String first_name, String last_name, int age, String sexe, String phone) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.sexe = sexe;
        this.phone = phone;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getAge() {
        return age;
    }

    public String getSexe() {
        return sexe;
    }

    public String getPhone() {
        return phone;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}