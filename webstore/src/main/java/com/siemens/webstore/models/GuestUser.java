package com.siemens.webstore.models;

public class GuestUser extends User{

    public GuestUser() {
        this.visitorCount++;
    }

    public GuestUser(String email) {
        this.email=email;
    }

    @Override
    public String toString() {
        return "GuestUser{" +
                "email='" + email + '\'' +
                '}';
    }
}
