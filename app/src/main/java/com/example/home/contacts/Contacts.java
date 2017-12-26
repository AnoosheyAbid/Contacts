package com.example.home.contacts;

/**
 * Created by home on 10/1/2017.
 */

public class Contacts {

    private String name, phone, gender;

    public Contacts() {


    }

    public Contacts(String name, String phone, String gender) {
        this.name = name;
        this.phone = phone;
        this.gender = gender;
    }


    //getters
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }


    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
