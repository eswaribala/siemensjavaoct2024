package com.siemens.webstore.models;

import java.util.regex.Pattern;

public class RegisteredUser extends User{

    private String userName;
    private String password;

    public RegisteredUser() {
        this.visitorCount++;
    }

    public RegisteredUser(String userName, String password,String email) {
        this.userName = userName;
        this.password = password;
        this.email=email;
    }

    @Override
    public String toString() {
        return "RegisteredUser{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    //static block
    static{
        System.out.println("Registered User Class Invoked...");
    }

    //instance block
    {
        System.out.println("Registered User Instance to be created");
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
