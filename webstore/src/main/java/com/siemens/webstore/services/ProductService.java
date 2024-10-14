package com.siemens.webstore.services;

import com.github.javafaker.Faker;
import com.siemens.webstore.models.Product;

public class ProductService {
    public static void main(String[] args){
        //declare the array
        Product[] products=new Product[10];
        Faker faker=new Faker();
        for(int i=0;i<products.length;i++){
            products[i]=new Product(faker.random().nextLong(1000),
                    faker.book().title(),
                    faker.book().author(),
                    faker.random().nextInt(1000,50000));
        }
        //see the products
        for(Product product : products){
            if(product.getProductId()>500)
               System.out.println(product);
        }


    }

}
