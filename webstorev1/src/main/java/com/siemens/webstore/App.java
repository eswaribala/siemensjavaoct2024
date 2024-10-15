package com.siemens.webstore;


import com.github.javafaker.Faker;
import com.siemens.webstore.dao.CatalogDao;
import com.siemens.webstore.dao.CatalogImpl;
import com.siemens.webstore.dao.ProductDao;
import com.siemens.webstore.dao.ProductImpl;
import com.siemens.webstore.models.Catalog;
import com.siemens.webstore.models.Product;
import com.siemens.webstore.services.CatalogService;
import com.siemens.webstore.services.CategoryService;
import com.siemens.webstore.services.ProductService;

import java.io.IOException;
import java.util.Iterator;

public class App {
    public static void main(String[] args) {

        //get data from array list
        Iterator iterator= CategoryService.generateCategories().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }




/*
       try {
            CatalogDao catalogDao=new CatalogImpl("logs","catalog.dat");
            for(Catalog catalog : CatalogService.generateCatalogs()){
                catalogDao.addCatalog(catalog);
            }
            catalogDao.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        CatalogDao catalogDao= null;
        try {
            catalogDao = new CatalogImpl("logs","catalog.dat");
            for(Catalog catalog : catalogDao.getCatalogs()){
                if(catalog!=null)
                  System.out.println(catalog);
            }
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }

 */
    }



}