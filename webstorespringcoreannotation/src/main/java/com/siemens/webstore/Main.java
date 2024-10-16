package com.siemens.webstore;

import com.siemens.webstore.models.Catalog;
import com.siemens.webstore.models.Category;
import com.siemens.webstore.models.CreditCard;
import com.siemens.webstore.models.SilverCreditCard;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.client.RestTemplate;

public class Main {
    public static void main(String[] args) {

        AbstractApplicationContext applicationContext=new
                ClassPathXmlApplicationContext("webstore-config.xml");

         applicationContext.registerShutdownHook();


        //IOC
        Category category= (Category) applicationContext.getBean("category");
        category.setCategoryId(123);
        category.setCategoryName("TV");
        category.setSubCategoryName("Sony");
        Catalog catalog= (Catalog) applicationContext.getBean("catalog");
        catalog.setCatalogId(1);
        catalog.setName("Electronics");
        catalog.setDescription("Home Appliances");
       // catalog.setCategory(category);

        System.out.println(catalog);

        SilverCreditCard silverCreditCard= (SilverCreditCard)
                applicationContext.getBean("silverCreditCard");

        System.out.println(silverCreditCard.getCountryData());


    }




}