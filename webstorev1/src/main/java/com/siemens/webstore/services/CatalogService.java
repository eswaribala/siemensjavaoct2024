package com.siemens.webstore.services;

import com.github.javafaker.Faker;
import com.siemens.webstore.models.Catalog;
import com.siemens.webstore.models.Category;

public class CatalogService {

    public static Catalog[] generateCatalogs(){

        Catalog[] catalogs=new Catalog[100];
        Faker faker=new Faker();
        for(int i=0;i<catalogs.length;i++){
            Category[] categories=new Category[2];
            for(int j=0;j<categories.length;j++){
                categories[j]=new Category(faker.random().nextInt(100,200),
                        faker.book().title(), faker.book().publisher());
            }

            catalogs[i]=new Catalog(faker.random().nextInt(1000,50000),
                    faker.commerce().productName(),faker.commerce().material(),
                    categories );
        }

        return catalogs;
    }

}
