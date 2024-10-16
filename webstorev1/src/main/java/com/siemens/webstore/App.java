package com.siemens.webstore;


import com.github.javafaker.Faker;
import com.siemens.webstore.dao.CatalogDao;
import com.siemens.webstore.dao.CatalogImpl;
import com.siemens.webstore.dao.ProductDao;
import com.siemens.webstore.dao.ProductImpl;
import com.siemens.webstore.models.Catalog;
import com.siemens.webstore.models.Category;
import com.siemens.webstore.models.Product;
import com.siemens.webstore.services.CatalogService;
import com.siemens.webstore.services.CategoryService;
import com.siemens.webstore.services.CategorySortService;
import com.siemens.webstore.services.ProductService;

import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) {
        //HashMap
/*
        HashMap<Long,Product> productHashMap=new HashMap<>();

        for(Product product: ProductService.generateProducts()){
            productHashMap.put(product.getProductId(),product);
        }
        //retrieve elements from hashmap

       Iterator iterator= productHashMap.entrySet().iterator();
        Map.Entry<Long,Product> mapEntry=null;
       while (iterator.hasNext()){
           mapEntry=(Map.Entry<Long,Product>)iterator.next();
           System.out.println(mapEntry.getKey()+"->"+mapEntry.getValue() );

       }


*/










        /*
        //priorityqueue

        PriorityQueue<Category> categoryPriorityQueue=new
                PriorityQueue<Category>(new CategorySortService());

        for(Category category : CategoryService.generateCategories()){
            categoryPriorityQueue.offer(category);
        }

        while(!categoryPriorityQueue.isEmpty()){
            System.out.println(categoryPriorityQueue.poll());
        }

*/


        //set
/*
        HashSet<Long> productSetA=new HashSet<Long>();
        HashSet<Long> productSetB=new HashSet<Long>();
        for(Product product : ProductService.generateProducts()){
            if(product.getProductId()%2==0)
                productSetA.add(product.getProductId());
            else
                productSetB.add(product.getProductId());
        }

        System.out.println("Before Union="+productSetA.size());
        //union
        productSetA.addAll(productSetB);
        System.out.println("Before Union="+productSetA.size());
        //intersection
        productSetA.retainAll(productSetB);
        System.out.println("After Intersection="+productSetA.size());
*/



        ArrayList<Category> categories=CategoryService.generateCategories();
        Comparator<Category> comparator=(category1,category2)->{
            if(category1.getCategoryId() == category2.getCategoryId())
                return 0;
            else if (category1.getCategoryId()>category2.getCategoryId()) {
                return 1;

            }
            else
                return -1;
        };


        categories.sort(comparator);

        //get data from array list
        Iterator iterator= categories.iterator();
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