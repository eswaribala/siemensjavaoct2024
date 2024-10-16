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

    private List<Category> categoryList;

    public Catalog(long catalogId, String name, String description) {
        this.catalogId = catalogId;
        this.name = name;
        this.description = description;
    }
    @Autowired
    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
