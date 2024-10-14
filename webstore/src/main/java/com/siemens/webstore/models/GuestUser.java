package com.siemens.webstore.models;

import java.util.regex.Pattern;

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

    //static block
    static{
        System.out.println("Guest User Class Invoked...");
    }

    //instance block
    {
        System.out.println("Guest User Instance to be created");
    }

    @Override
    public boolean validateEmail() {
        Pattern pattern=Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        if(pattern.matcher(this.email).matches()){
            return true;
        }else
            return false;
    }
}
