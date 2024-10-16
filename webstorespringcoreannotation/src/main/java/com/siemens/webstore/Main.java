package com.siemens.webstore;

import com.siemens.webstore.models.Catalog;
import com.siemens.webstore.models.CreditCard;
import com.siemens.webstore.models.SilverCreditCard;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext=new
                ClassPathXmlApplicationContext("webstore-config.xml");

        //IOC
        Catalog catalog= (Catalog) applicationContext.getBean("catalog");
        System.out.println(catalog);

    }
}