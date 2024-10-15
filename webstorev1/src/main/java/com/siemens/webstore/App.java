package com.siemens.webstore;


import com.github.javafaker.Faker;
import com.siemens.webstore.dao.CatalogDao;
import com.siemens.webstore.dao.CatalogImpl;
import com.siemens.webstore.dao.ProductDao;
import com.siemens.webstore.dao.ProductImpl;
import com.siemens.webstore.models.Catalog;
import com.siemens.webstore.models.Product;
import com.siemens.webstore.services.CatalogService;
import com.siemens.webstore.services.ProductService;

import java.io.IOException;

public class App {
    public static void main(String[] args) {

        try {
            CatalogDao catalogDao=new CatalogImpl("logs","catalog.dat");
            for(Catalog catalog : CatalogService.generateCatalogs()){
                catalogDao.addCatalog(catalog);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*
        try {
            ProductDao productDao=new ProductImpl("logs","product.csv");
            for(Product product:productDao.getProducts()){
                System.out.println(product);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
*/

    }



}