package com.siemens.webstore;

import com.siemens.webstore.models.Catalog;
import com.siemens.webstore.models.CreditCard;
import com.siemens.webstore.models.SilverCreditCard;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
    public static void main(String[] args) {

      //IOC
        //step1
        Resource resource= new ClassPathResource("webstore-config.xml");
        //step2
        //container
        DefaultListableBeanFactory defaultListableBeanFactory=new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader=new XmlBeanDefinitionReader
                (defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(resource);
        //step3
        //Implementing IOC
        Catalog catalog1= (Catalog) defaultListableBeanFactory.getBean("catalog");
        //After DI
        System.out.println(catalog1);

        //Singleton
        Catalog catalog2= (Catalog) defaultListableBeanFactory.getBean("catalog");

       catalog2.setName("Furniture");
       catalog2.setDescription("Home Furniture");
        System.out.println(catalog1);

        //silver card
        SilverCreditCard silverCreditCard= (SilverCreditCard) defaultListableBeanFactory.getBean("silverCreditCard");
        System.out.println(silverCreditCard.getCreditCardNo()
                +","+silverCreditCard.getCvv()+","
                +silverCreditCard.getUsageLimit());
    }
}