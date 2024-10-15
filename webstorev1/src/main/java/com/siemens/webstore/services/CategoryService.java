package com.siemens.webstore.services;

import com.github.javafaker.Faker;
import com.siemens.webstore.models.Catalog;
import com.siemens.webstore.models.Category;

import java.util.ArrayList;

public class CategoryService {

    public static ArrayList<Category> generateCategories(){
        ArrayList<Category> categories=new ArrayList<>(50);
        Faker faker=new Faker();
        for(int i=0;i<100;i++){
            categories.add(new Category(faker.random().nextInt(100,200),
                        faker.book().title(), faker.book().publisher()));

        }
        return categories;
    }
}
