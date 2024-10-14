package com.siemens.webstore;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        System.out.println("Kick starting web store project...");
        readApp();
    }

    public static void readApp(){
        //read input from user

        Scanner scanner=new Scanner(System.in);
        //declare two variables
        String firstName="";
        long phoneNo=0L;
        System.out.println("Enter First Name");
        firstName=scanner.nextLine();

        System.out.println("Enter Phone No");
        phoneNo=scanner.nextLong();
        scanner.nextLine();

        //show the outcome
        System.out.println("First Name="+firstName);
        System.out.println("Phone No="+phoneNo);

    }

}