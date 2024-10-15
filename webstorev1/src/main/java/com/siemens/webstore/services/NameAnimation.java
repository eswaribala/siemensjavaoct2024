package com.siemens.webstore.services;

public class NameAnimation extends Thread{
    private String name;
    public NameAnimation(String name){
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
