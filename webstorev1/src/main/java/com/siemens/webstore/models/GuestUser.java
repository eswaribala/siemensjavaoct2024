package com.siemens.webstore.models;

public class GuestUser extends User implements Runnable{
    public GuestUser(String name) {
        this.name=name;
    }

    @Override
    public void run() {
        for(char ch : name.toCharArray())
        {
            System.out.println(ch);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
