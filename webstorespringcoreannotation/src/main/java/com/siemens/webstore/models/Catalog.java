package com.siemens.webstore.models;

import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class Catalog{
    private long catalogId;
    private String name;
    private String description;
    @Autowired
    //@Qualifier(value="category1") //by type
    private Category category;

    public Catalog(long catalogId, String name, String description) {
        this.catalogId = catalogId;
        this.name = name;
        this.description = description;
    }
    @Bean

    public RestTemplate getRestTemplateInstance(){
        //java instance into spring bean
        return new RestTemplate();
    }

    @PreDestroy
    public void beforeDestroy(){
        System.out.println("Pre destroy invoked....");
    }
}
