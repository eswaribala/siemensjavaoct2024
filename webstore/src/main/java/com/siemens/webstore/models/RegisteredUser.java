package com.siemens.webstore.models;

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
}
