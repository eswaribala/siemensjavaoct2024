package com.siemens.webstore.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalog{
    private long catalogId;
    private String name;
    private String description;
    //has relationship
    private List<Category> categoryList;
    @Autowired
    public Catalog(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
