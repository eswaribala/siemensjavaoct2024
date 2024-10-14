package com.siemens.webstore;

import com.siemens.webstore.models.Catalog;
import com.siemens.webstore.models.GuestUser;
import com.siemens.webstore.models.RegisteredUser;
import com.siemens.webstore.models.User;
import com.siemens.webstore.services.CatalogService;
import com.siemens.webstore.services.DbService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        System.out.println("Kick starting web store project...");
        readApp();
    }

    public static void readApp(){
        //read input from user
/*
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
        System.out.println("Phone No="+phoneNo);*/

        /**/

        CatalogService catalogService=new CatalogService();
       /* Catalog catalog=new Catalog();
        catalog.setCatalogId(1);
        catalog.setName("Electronics");
        catalog.setDescription("Home Appliances");*/
        catalogService.addCatalog(new Catalog(1,"56324654",
                "Home Appliances"));
        System.out.println(catalogService.getCatalogName(1));

       //DbService
        //1st object
        DbService dbService1=DbService.getInstance();
        System.out.println(DbService.count);
        //2nd time object
        //dbService1=DbService.getInstance();

        //inheritance
        GuestUser guestUser=new GuestUser("Param@gmail.com");
        RegisteredUser registeredUser=new RegisteredUser("User1",
                "Test@123","user@gmail.com");

        //polymorphism
         User user=new RegisteredUser("User1",
                 "Test@123","user@gmail.com");

         System.out.println(user.validateEmail());
          System.out.println(user);

         // User user1=new User();
       // System.out.println(user1);


    }

}