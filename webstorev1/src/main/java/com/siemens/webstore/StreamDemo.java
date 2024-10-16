package com.siemens.webstore;

import com.siemens.webstore.services.CategoryService;

public class StreamDemo {
    public static void main(String[] args){

        CategoryService.generateCategories().stream().sorted((cat1,cat2)->{
            if(cat1.getCategoryId() == cat2.getCategoryId())
                return 0;
            else if (cat1.getCategoryId()>cat2.getCategoryId()) {
                return 1;

            }
            else
                return -1;
        }).map(c->c.getCategoryName())

                .filter(c->c.startsWith("L"))


                .forEach(System.out::println);


    }
}
