package com.siemens.webstore;


import com.github.javafaker.Faker;
import com.siemens.webstore.dao.ProductDao;
import com.siemens.webstore.dao.ProductImpl;
import com.siemens.webstore.models.Product;
import com.siemens.webstore.services.ProductService;

import java.io.IOException;

public class App {
    public static void main(String[] args) {

        try {
            ProductDao productDao=new ProductImpl("logs","product.csv");
            for(Product product : ProductService.generateProducts()){
                productDao.addProduct(product);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



}