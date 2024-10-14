package com.siemens.webstore.services;

import com.github.javafaker.Faker;
import com.siemens.webstore.exceptions.ProductCostException;
import com.siemens.webstore.models.Product;

public class ProductService {
    public static void main(String[] args){
        //declare the array
        Product[] products=new Product[10];
        Faker faker=new Faker();
        for(int i=0;i<products.length;i++){
           // try {
                products[i] = new Product(faker.random().nextLong(1000),
                        faker.book().title(),
                        faker.book().author(),
                        faker.random().nextInt(-1000, -500));
           /* }catch(ProductCostException p){
                System.out.println(p.getMessage());
               StackTraceElement[] stackTraceElements= p.getStackTrace();
               for(StackTraceElement stackTraceElement: stackTraceElements){
                   System.out.println(stackTraceElement.getFileName());
                   System.out.println(stackTraceElement.getClassName());
                   System.out.println(stackTraceElement.getMethodName());
                   System.out.println(stackTraceElement.getLineNumber());
               }*/

            }
        }
      /*  //see the products
        for(Product product : products){
            if(product.getProductId()>500)
               System.out.println(product);
        }*/


    }

}
