package com.siemens.webstore.services;
import com.siemens.webstore.models.Catalog;
public class CatalogService {
    private Catalog catalog;

    public Catalog addCatalog(Catalog catalog){
        this.catalog=catalog;
        return this.catalog;
    }

    public String getCatalogName(long catalogId){
        if(catalog.getCatalogId()==catalogId)
            return catalog.getName();
        else
            return null;
    }

}
