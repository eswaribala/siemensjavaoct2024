package com.siemens.webstore.models;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Catalog implements Serializable {
    private long catalogId;
    private String name;
    private String description;
    private Category[] categories;




//create default constructor

    public Catalog() {
    }

  //parameterized constructor

    public Catalog(long catalogId, String name, String description, Category[] categories) {
        this(name);
        this.catalogId = catalogId;
        this.description = description;
        this.categories=categories;
    }

    public Catalog(String name){
       Pattern pattern=Pattern.compile("[A-Za-z]+");
       if(pattern.matcher(name).matches()){
           this.name=name;
       }else
           this.name=null;


    }

    public Catalog(long catalogId, String name, String description) {
        this(name);
        this.catalogId = catalogId;
        this.description = description;

    }

    //generate mutators and accessors


    public Category[] getCategories() {
        return categories;
    }

    public void setCategories(Category[] categories) {
        this.categories = categories;
    }

    public long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(long catalogId) {
        this.catalogId = catalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
