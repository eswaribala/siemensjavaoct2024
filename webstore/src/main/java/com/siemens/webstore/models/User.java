package com.siemens.webstore.models;

public abstract class User {

    protected int visitorCount;
    public String email;
    //static block
    static{
        System.out.println("User Class Invoked...");
    }

    //instance block
    {
        System.out.println("User Instance to be created");
    }
    public abstract boolean validateEmail();
}
