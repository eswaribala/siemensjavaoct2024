package com.siemens.webstore;


import com.github.javafaker.Faker;
import com.siemens.webstore.dao.ProductDao;
import com.siemens.webstore.dao.ProductImpl;
import com.siemens.webstore.models.Product;

import java.io.IOException;

public class App {
    public static void main(String[] args) {

        try {
            ProductDao productDao=new ProductImpl("logs","product.csv");
            for(Product product : generateProducts()){
                productDao.addProduct(product);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

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