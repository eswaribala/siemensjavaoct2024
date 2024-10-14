package com.siemens.webstore.models;

public class User {

    protected int visitorCount;
    protected String email;
    //static block
    static{
        System.out.println("User Class Invoked...");
    }

    //instance block
    {
        System.out.println("User Instance to be created");
    }
}
