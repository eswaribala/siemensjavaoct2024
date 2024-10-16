package com.siemens.webstore;

import com.siemens.webstore.models.Catalog;
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
        Catalog catalog= (Catalog) defaultListableBeanFactory.getBean("catalog");
        System.out.println(catalog.getCatalogId());




    }
}