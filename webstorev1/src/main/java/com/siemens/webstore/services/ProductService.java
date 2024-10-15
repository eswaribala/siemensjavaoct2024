package com.siemens.webstore.services;

import com.github.javafaker.Faker;
import com.siemens.webstore.models.Product;

public class ProductService {


    public static Product[] generateProducts(){
        Product[] products=new Product[100];
        Faker faker=new Faker();
        for(int i=0;i<products.length;i++){
            // try {
            products[i] = new Product(faker.random().nextLong(1000),
                    faker.book().title(),
                    faker.book().author(),
                    faker.random().nextInt(1000, 5000));


        }

        return products;
    }

}
