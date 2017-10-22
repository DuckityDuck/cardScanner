package com.abbyy.mobile.sample;

/**
 * Created by delta on 10/21/2017.
 */

public class ScannedCard {

    private static String name;

    private String email;

    private String phone;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "Name: " + this.getName() + "\n" + "Email: " + this.getEmail() + "\n" + "Phone Number: " + this.getPhone();
    }
}
