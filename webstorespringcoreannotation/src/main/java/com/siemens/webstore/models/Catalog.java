package com.siemens.webstore.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
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

}
