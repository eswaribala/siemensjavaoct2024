package com.siemens.webstore;

import com.github.javafaker.Faker;
import com.siemens.webstore.exceptions.DbServiceSingletonException;
import com.siemens.webstore.models.Catalog;
import com.siemens.webstore.models.GuestUser;
import com.siemens.webstore.models.RegisteredUser;
import com.siemens.webstore.models.User;
import com.siemens.webstore.services.CatalogService;
import com.siemens.webstore.services.DbService;
import com.siemens.webstore.services.GuestUserService;

import java.util.Arrays;
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

        try {
            DbService dbService1=DbService.getInstance();
            System.out.println(DbService.count);
        } catch (DbServiceSingletonException e) {
            throw new RuntimeException(e);
        }



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

        //sort the registered users
        RegisteredUser[] registeredUsers=generateRegisteredUsers();
        Arrays.sort( registeredUsers);
        for(RegisteredUser registeredUser1 : registeredUsers){
            System.out.println(registeredUser1);
        }

        //sort the guest users
        GuestUser[] guestUsers=generateGuestUsers();
        Arrays.sort(guestUsers,new GuestUserService());

        for(GuestUser guestUser1 : guestUsers){
            System.out.println(guestUser1);
        }



    }

    public static RegisteredUser[] generateRegisteredUsers(){

        RegisteredUser[] registeredUsers=new RegisteredUser[100];
        Faker faker=new Faker();
        for(int i=0;i<registeredUsers.length;i++){
            registeredUsers[i]=new RegisteredUser(faker.name().firstName(),faker.internet().password(),
                    faker.internet().emailAddress());
        }
        return registeredUsers;
    }


    public static GuestUser[] generateGuestUsers(){

       GuestUser[] guestUsers=new GuestUser[100];
        Faker faker=new Faker();
        for(int i=0;i<guestUsers.length;i++){
            guestUsers[i]=new GuestUser(faker.internet().emailAddress());
        }
        return guestUsers;
    }
}